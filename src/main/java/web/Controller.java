package web;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import lifeline.Lifelines;
import mapper.BitLevelMapperManaged;
import mapper.QuestionMapperSQL;
import mapper.UserMapperFile;
import model.Game;
import model.User;

import javax.servlet.annotation.WebServlet;
import java.io.File;


public class Controller extends UI
{

    private static Game engine = null;



    @Override
    public void init(VaadinRequest request)
    {
        if (Controller.engine == null)
            this.CreateEngine();

        switch (Controller.engine.getStatus())
        {
            case START:
                setContent(Start.init(this));
                break;
            case QUESTION:
                setContent(Question.init(this));
                break;
            case END:
                setContent(End.init(this));
                break;
        }
    }



    private void CreateEngine()
    {
        Controller.engine = new Game(
                new QuestionMapperSQL(),
                new UserMapperFile(
                        new File(
                                getClass().getClassLoader().getResource("score.txt").getFile()
                        )
                ),
                new BitLevelMapperManaged(),
                new Lifelines()
        );
    }




    public void NewPlayer(String name)
    {
        Controller.engine.setPlayer( new User(name) );
    }




    @WebServlet(urlPatterns = "/*", name = "BittiServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Controller.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
