import lifeline.Lifeline;
import mapper.QuestionMapper;
import mapper.UserMapper;
import model.User;

import java.util.List;

/**
 * Created by valje on 2.4.2016.
 */

public class Game {
    int CurrentLevel, CurrentQuestion;
    User player;
    QuestionMapper questions;
    UserMapper users;
    List<Lifeline> lifelines;                   // Pitäiskö tämä olla Lifelines-luokassa, kuten users?



    public Game(User player, QuestionMapper questions, UserMapper users, List<Lifeline> lifelines) {
        this.CurrentLevel = 1;
        this.player = player;
        this.questions = questions;
        this.users = users;
        this.lifelines = lifelines;
    }



    public int getCurrentLevel() {
        return CurrentLevel;
    }



    public void setCurrentLevel(int currentLevel) {
        CurrentLevel = currentLevel;
    }



    public int getCurrentQuestion() {
        return CurrentQuestion;
    }



    public void setCurrentQuestion(int currentQuestion) {
        CurrentQuestion = currentQuestion;
    }



    public QuestionMapper getQuestions() {
        return questions;
    }



    public List<Lifeline> getLifelines() {
        return lifelines;
    }
}
