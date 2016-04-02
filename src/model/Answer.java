package model;



public class Answer
{
    private int answerId;
    private int questionId;
    private String answer;



    public Answer(int answerId, int questionId, String answer)
    {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answer = answer;
    }



    public int getQuestionId()
    {
        return questionId;
    }



    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }



    public int getAnswerId()
    {
        return answerId;
    }



    public void setAnswerId(int answerId)
    {
        this.answerId = answerId;
    }



    public String getAnswer()
    {
        return answer;
    }



    public void setAnswer(String answer)
    {
        this.answer = answer;
    }



    public String toString()
    {
        return "Answer [" +
                "answerId: " + this.answerId + ", " +
                "questionId: " + this.questionId + " , " +
                "answer: " + this.answer + "]";
    }
}
