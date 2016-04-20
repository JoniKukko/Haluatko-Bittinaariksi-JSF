package model;

//import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;


//@ManagedBean
public class User
{
    @Size(min=1, max=40)
    private String name;
    private String score;



    public User()
    {
    }



    public User(String name)
    {
        this.name = name;
    }



    public User(String name, String score)
    {
        this.name = name;
        this.score = score;
    }



    public String getName()
    {
        return name;
    }



    public void setName(String name)
    {
        this.name = name;
    }



    public String getScore()
    {
        return score;
    }



    public void setScore(String score)
    {
        this.score = score;
    }
}
