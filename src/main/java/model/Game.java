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
        this.status = Status.START;
        this.CurrentLevel = 1;

        this.questions = questions;
        this.users = users;
        this.bitlevels = bitlevels;
        this.lifelines = lifelines;
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

    public Status getStatus() {
        return status;
    }

    public void setPlayer(User player) {
        this.player = player;
        this.status = Status.QUESTION;
    }
}
