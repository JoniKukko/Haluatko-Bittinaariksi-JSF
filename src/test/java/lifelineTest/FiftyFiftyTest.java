package lifelineTest;

import interfaces.ILifeline;
import lifeline.FiftyFifty;
import model.Answer;
import model.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class FiftyFiftyTest
{
    private ILifeline lifeline;



    @Before
    public void setUp() throws Exception
    {
        // luodaan dummy question vastausvaihtoehtoineen
        // oikea vastaus on vastaus 1
        Question question = new Question(1, 1, "Kysymys", 1);
        question.addAnswer( new Answer(1, 1, "Vastaus 1") );
        question.addAnswer( new Answer(2, 1, "Vastaus 2") );
        question.addAnswer( new Answer(3, 1, "Vastaus 3") );
        question.addAnswer( new Answer(4, 1, "Vastaus 4") );

        this.lifeline = new FiftyFifty();
        this.lifeline.useLifeline(question);
    }



    @Test
    public void testFiftyFifty() throws Exception
    {
        Question newQuestion = this.lifeline.getQuestion();
        List<Answer> answers = newQuestion.getAnswers();

        // fiftyfiftyllä questionista pitää olla lähtenyt kaksi
        assertEquals(2, answers.size());
    }



    @Test
    public void testCorrectAnswer() throws Exception
    {
        Question newQuestion = this.lifeline.getQuestion();
        List<Answer> answers = newQuestion.getAnswers();

        // ja oikean vastauksen pitää olla vielä siellä
        boolean correctAnswerFound = false;
        for (Answer answer : answers)
        {
            if (answer.getAnswerId() == newQuestion.getCorrectAnswerId())
                correctAnswerFound = true;
        }

        assertEquals(true, correctAnswerFound);
    }



    @Test
    public void getResult() throws Exception
    {
        // fiftyfiftyllä vastauksen tulee olla null
        assertEquals(null, this.lifeline.getResult());
    }
}