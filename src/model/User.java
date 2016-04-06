package model;



import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;

// Korjattu!

@ManagedBean
public class User
{
    @Size(min=1, max=40)
    private String name;
    private int score = 0;



    public User()
    {
    }



    public User(String name)
    {
        this.name = name;
    }



    public User(String name, int score)
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



    public int getScore()
    {
        return score;
    }



    public void setScore(int score)
    {
        this.score = score;
    }
}
