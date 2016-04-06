import lifeline.ILifelines;
import mapper.IQuestionMapper;
import mapper.IUserMapper;
import model.Question;
import model.User;



public class Game
{
    private int CurrentLevel;
    private Question CurrentQuestion;
    private User player;
    private IQuestionMapper questions;
    private IUserMapper users;
    private ILifelines lifelines;



    public Game(User player, IQuestionMapper questions, IUserMapper users, ILifelines lifelines)
    {
        this.CurrentLevel = 1;
        this.player = player;
        this.questions = questions;
        this.users = users;
        this.lifelines = lifelines;

        this.updateCurrentQuestion();
    }



    public int getCurrentLevel()
    {
        return CurrentLevel;
    }



    public boolean checkAnswer(int answerId)
    {
        boolean flag = (this.CurrentQuestion.getCorrectAnswerId() == answerId);

        if (flag) {
            this.CurrentLevel++;
            updateCurrentQuestion();
        }

        return flag;
    }



    public void setCurrentLevel(int currentLevel)
    {
        CurrentLevel = currentLevel;
    }



    private void updateCurrentQuestion()
    {
        this.CurrentQuestion = this.questions.getRandomQuestionByLevel(this.CurrentLevel);
    }



    public Question getCurrentQuestion()
    {
        return CurrentQuestion;
    }



    public void setCurrentQuestion(Question currentQuestion)
    {
        CurrentQuestion = currentQuestion;
    }



    public IQuestionMapper getQuestions()
    {
        return questions;
    }



    public ILifelines getLifelines()
    {
        return lifelines;
    }

    public User getPlayer() {
        return player;
    }
}
