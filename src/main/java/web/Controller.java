package web;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import interfaces.ILifeline;
import lifeline.AskTheAudience;
import lifeline.CallHome;
import lifeline.FiftyFifty;
import lifeline.Lifelines;
import mapper.BitLevelMapperManaged;
import mapper.QuestionMapperSQL;
import mapper.UserMapperFile;
import model.*;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.util.ArrayList;



public class Controller extends UI
{
    private static Game engine;



    private void init (final VaadinRequest request, String lifelineString)
    {
        Layout layout = null;

        switch (getEngine().getStatus())
        {
            case START:
                layout = this.start(request);
                break;

            case QUESTION:
                layout = this.question(request, lifelineString);
                break;

            case END:
                layout = this.end(request);
                break;
        }

        Label header = new Label("GAME STATUS: " + getEngine().getStatus().toString());
        layout.addComponent(header);
        setContent(layout);
    }



    private Layout start(final VaadinRequest request)
    {
        // alustukset
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent( new Label("Terve, Vaaditko Bittinääriksiiiii?!?!?") );
        final TextField nameInput = new TextField("Anna nimesi");

        Button button = new Button("Aloita peli");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                getEngine().setPlayer( new User(nameInput.getValue()) );
                init(request);
            }
        });

        layout.addComponent(nameInput);
        layout.addComponent(button);

        // top-lista looppi
        layout.addComponent( new Label("TOP-LISTA: "));
        for (User player : getEngine().getUsers().getUsers())
            layout.addComponent( new Label(player.getName() + " " + player.getScore()));

        return layout;
    }



    private Layout question(final VaadinRequest request, String lifelineResult)
    {
        // alustukset
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent( new Label("Terve " + getEngine().getPlayer().getName() +", Vaaditko Bittinääriksiiiii?!?!?") );
        layout.addComponent( new Label("Kysymys " + (getEngine().getCurrentLevel() + 1) + "/15") );

        // kysymys
        Question question = getEngine().getCurrentQuestion();
        layout.addComponent( new Label(question.getQuestion()) );

        // jos lifeline on sanonut jotain
        if (lifelineResult != null)
            layout.addComponent( new Label("Oljenkorsi sanoo: " + lifelineResult) );

        // vastausvaihtoehdot
        for(final Answer answer : question.getAnswers())
        {
            Button button = new Button(answer.getAnswer());
            button.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                    getEngine().checkAnswer( answer.getAnswerId() );
                    init(request);
                }
            });
            layout.addComponent( button );
        }

        // käyttämättömät oljenkorret
        layout.addComponent( new Label("Oljenkorret: ") );
        for (final ILifeline lifeline : getEngine().getLifelines().getLifelines())
        {
            Button button = new Button(lifeline.getName());
            button.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                    lifeline.useLifeline(getEngine().getCurrentQuestion());
                    getEngine().setCurrentQuestion(lifeline.getQuestion());
                    getEngine().getLifelines().removeLifeline(lifeline);
                    init(request, lifeline.getResult());
                }
            });
            layout.addComponent( button );
        }

        // Portaikko
        layout.addComponent( new Label("Portaat: ") );
        for (BitLevel level : getEngine().getBitlevels().getBitLevels())
        {
            if (level.getLevel() != 0)
            {
                if (getEngine().getCurrentLevel() == level.getLevel())
                    layout.addComponent(new Label("! " + level.getLevel() + " : " + level.getBits()));
                else if (getEngine().getCurrentLevel()+1 == level.getLevel())
                    layout.addComponent(new Label("=> " + level.getLevel() + " : " + level.getBits()));
                else
                    layout.addComponent(new Label(level.getLevel() + " : " + level.getBits()));
            }
        }

        return layout;
    }



    private Layout end(final VaadinRequest request)
    {
        // alustukset
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent( new Label("Terve " + getEngine().getPlayer().getName() +", Vaaditko Bittinääriksiiiii?!?!?") );
        layout.addComponent( new Label("Peli päättyi.") );
        layout.addComponent( new Label("Voitit " + getEngine().getBitlevels().getBitsByLevel(getEngine().getCurrentLevel())));

        // uudestaan nappula
        Button button = new Button("Pelataanko uudestaan?");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Controller.engine = null;
                init(request, null);
            }
        });
        layout.addComponent( button );

        return layout;
    }



    private Game getEngine()
    {
        if (Controller.engine == null)
        {
            ArrayList<ILifeline> lifelines = new ArrayList<ILifeline>();
            lifelines.add(new AskTheAudience());
            lifelines.add(new CallHome());
            lifelines.add(new FiftyFifty());

            Controller.engine = new Game(
                    new QuestionMapperSQL(),
                    new UserMapperFile(
                            new File( getClass().getClassLoader().getResource("score.txt").getFile() )
                    ),
                    new BitLevelMapperManaged(),
                    new Lifelines(lifelines)
            );
        }

        return Controller.engine;
    }



    @WebServlet(urlPatterns = {"/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = Controller.class, productionMode = false)
    public static class ControllerServlet extends VaadinServlet {}

    @Override
    protected void init(final VaadinRequest request)
    {
        this.init(request, null);
    }
}
