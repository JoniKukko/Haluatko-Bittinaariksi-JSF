package model;



import javax.faces.bean.ManagedBean;



@ManagedBean
public class User
{
    private String name = null;
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
