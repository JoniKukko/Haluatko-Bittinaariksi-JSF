import javax.faces.bean.ManagedBean;



@ManagedBean
public class Controller
{
    public String newGame()
    {
        return "question?faces-redirect=true";
    }


    public String answer(int answerId)
    {
        if (answerId == 2)
            return "end?faces-redirect=true";

        return null;
    }


    public String lifeline(int lifelineId)
    {
        if (lifelineId == 3)
            return "start?faces-redirect=true";

        return null;
    }
}
