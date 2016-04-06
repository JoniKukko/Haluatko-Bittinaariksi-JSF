import lifeline.Lifelines;
import mapper.IUserMapper;
import mapper.QuestionMapperSQL;
import model.Answer;
import model.User;
import model.Users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;


class temp implements IUserMapper {

    public void saveUser(User user) {

    }

    public Users loadUsers() {
        return null;
    }

    public Users getRepository() {
        return null;
    }

    public void saveUsers() {

    }
}


@ManagedBean
@SessionScoped
public class Controller implements java.io.Serializable
{
    private Game engine;



    public String newGame()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        User player = (User)facesContext.getExternalContext().getRequestMap().get("user");

        this.engine = new Game(player, new QuestionMapperSQL(), new temp(), new Lifelines());

        return "question?faces-redirect=true";
    }


    public String answer(int answerId)
    {
        // jos vastaus on _väärin_ (hox "!") niin engine tuhotaan ja siirrytään endiin
        if (!this.engine.checkAnswer(answerId))
        {
            this.engine = null;
            return "end?faces-redirect=true";
        }

        // jos vastaus ei ollut väärin niin palautetaan null että pysytään samalla sivulla
        return null;
    }


    public String lifeline(int lifelineId)
    {
        // @TODO tämä koko setti on vaan dummy
        if (lifelineId == 3)
            return "start?faces-redirect=true";

        return null;
    }



    public String getPlayerName()
    {
        return this.engine.getPlayer().getName();
    }



    public int getLevel()
    {
        return this.engine.getCurrentLevel();
    }


    public String getQuestion()
    {
        return this.engine.getCurrentQuestion().getQuestion();
    }


    public List<Answer> getAnswers()
    {
        return this.engine.getCurrentQuestion().getAnswers();
    }
}
