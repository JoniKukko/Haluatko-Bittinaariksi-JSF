package lifelineTest;

import interfaces.ILifeline;
import lifeline.CallHome;
import model.Answer;
import model.Question;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;



public class CallHomeTest
{
    private ILifeline lifeline;
    private Question question;



    @Before
    public void setUp() throws Exception
    {
        // luodaan dummy question vastausvaihtoehtoineen
        // oikea vastaus on vastaus 1
        this.question = new Question(1, 1, "Kysymys", 1);
        this.question.addAnswer( new Answer(1, 1, "Vastaus 1") );
        this.question.addAnswer( new Answer(2, 1, "Vastaus 2") );
        this.question.addAnswer( new Answer(3, 1, "Vastaus 3") );
        this.question.addAnswer( new Answer(4, 1, "Vastaus 4") );

        this.lifeline = new CallHome(this.question);
    }



    @Test
    public void getQuestion() throws Exception
    {
        // call home ei saa muuttaa questionia
        assertEquals(this.question, this.lifeline.getQuestion());
    }



    @Test
    public void getResult() throws Exception
    {
        // get result ei saa olla null
        assertNotEquals(null, this.lifeline.getResult());
        System.out.println("Vastaaja: " + this.lifeline.getResult());
        System.out.println("Oikea vastaus: " + this.question.getCorrectAnswerId());
    }
}