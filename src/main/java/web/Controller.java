package web;


import lifeline.Lifelines;
import mapper.BitLevelMapperManaged;
import mapper.QuestionMapperSQL;
import mapper.UserMapperFile;
import model.Game;
import model.User;

import javax.servlet.annotation.WebServlet;
import java.io.File;


public class Controller
{

    private static Game engine;


    public Controller()
    {
        if (Controller.engine == null)
            this.CreateEngine();
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

}
