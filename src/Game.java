import lifeline.ILifeline;
import mapper.IQuestionMapper;
import mapper.IUserMapper;
import model.User;
import java.util.List;



public class Game
{
    private int CurrentLevel, CurrentQuestion;
    private User player;
    private IQuestionMapper questions;
    private IUserMapper users;
    private List<ILifeline> lifelines;                   // Pitäiskö tämä olla Lifelines-luokassa, kuten users?



    public Game(User player, IQuestionMapper questions, IUserMapper users, List<ILifeline> lifelines)
    {
        this.CurrentLevel = 1;
        this.player = player;
        this.questions = questions;
        this.users = users;
        this.lifelines = lifelines;
    }



    public int getCurrentLevel()
    {
        return CurrentLevel;
    }



    public void setCurrentLevel(int currentLevel)
    {
        CurrentLevel = currentLevel;
    }



    public int getCurrentQuestion()
    {
        return CurrentQuestion;
    }



    public void setCurrentQuestion(int currentQuestion)
    {
        CurrentQuestion = currentQuestion;
    }



    public IQuestionMapper getQuestions()
    {
        return questions;
    }



    public List<ILifeline> getLifelines()
    {
        return lifelines;
    }
}
