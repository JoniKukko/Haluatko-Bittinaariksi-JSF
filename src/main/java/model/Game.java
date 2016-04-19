package model;

import interfaces.IBitLevelMapper;
import interfaces.ILifelines;
import interfaces.IQuestionMapper;
import interfaces.IUserMapper;



public class Game
{
    private Status status;
    private int CurrentLevel;
    private Question CurrentQuestion;
    private User player;
    private IQuestionMapper questions;
    private IUserMapper users;
    private IBitLevelMapper bitlevels;
    private ILifelines lifelines;



    public Game(IQuestionMapper questions, IUserMapper users, IBitLevelMapper bitlevels, ILifelines lifelines)
    {
        this.newGame();

        this.questions = questions;
        this.users = users;
        this.bitlevels = bitlevels;
        this.lifelines = lifelines;

        this.updateCurrentQuestion();
    }



    public void newGame()
    {
        this.status = Status.START;
        this.CurrentLevel = 1;
    }



    public void checkAnswer(int answerId)
    {
        if (this.CurrentQuestion.getCorrectAnswerId() == answerId)
        {
            this.CurrentLevel++;
            updateCurrentQuestion();
            this.player.setScore(this.bitlevels.getRepository().getBitsByLevel(this.CurrentLevel));
        }
        else
        {
            this.status = Status.END;
            this.users.saveUser( this.getPlayer() );
        }
    }



    public void setPlayer(User player)
    {
        this.player = player;
        this.status = Status.QUESTION;
    }



    public User getPlayer()
    {
        return player;
    }



    public int getCurrentLevel()
    {
        return CurrentLevel;
    }



    public Question getCurrentQuestion()
    {
        return CurrentQuestion;
    }



    public void setCurrentQuestion(Question newQuestion)
    {
        this.CurrentQuestion = newQuestion;
    }



    public Status getStatus()
    {
        return status;
    }


    private void updateCurrentQuestion()
    {
        this.CurrentQuestion = this.questions.getRandomQuestionByLevel(this.CurrentLevel);
    }



    public ILifelines getLifelines() {
        return lifelines;
    }

    public BitLevels getBitlevels() {
        return bitlevels.getRepository();
    }

    public Users getUsers() { return this.users.getRepository(); }
}
