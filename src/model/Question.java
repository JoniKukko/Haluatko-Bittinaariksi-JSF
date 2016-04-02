package model;



import java.util.List;



public class Question
{
    private int questionId;
    private int correctAnswerId;
    private String question;
    private int level;
    private List<Answer> answers;



    public Question()
    {
    }



    public Question(int questionId, int correctAnswerId, String question, int level, List<Answer> answers)
    {
        this.questionId = questionId;
        this.correctAnswerId = correctAnswerId;
        this.question = question;
        this.level = level;
        this.answers = answers;
    }



    public int getQuestionId()
    {
        return this.questionId;
    }



    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }



    public int getCorrectAnswerId()
    {
        return this.correctAnswerId;
    }



    public void setCorrectAnswerId(int correctAnswerId)
    {
        this.correctAnswerId = correctAnswerId;
    }



    public String getQuestion()
    {
        return this.question;
    }



    public void setQuestion(String question)
    {
        this.question = question;
    }



    public int getLevel()
    {
        return this.level;
    }



    public void setLevel(int level)
    {
        this.level = level;
    }



    public List<Answer> getAnswers()
    {
        return this.answers;
    }



    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }



    public void addAnswer(Answer answer)
    {
        this.answers.add(answer);
    }
}
