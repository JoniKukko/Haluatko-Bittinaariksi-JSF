package model;

import java.util.List;

/**
 * Created by valje on 2.4.2016.
 */

public class Question {
    private List<String> answers;
    private int rightAnswer;



    public List<String> getAnswers() {
        return answers;
    }



    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }



    public int getRightAnswer() {
        return rightAnswer;
    }



    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
