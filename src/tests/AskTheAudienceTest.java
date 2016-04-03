package tests;



import lifeline.AskTheAudience;
import lifeline.ILifeline;
import model.Answer;
import model.Question;
import org.junit.*;
import static org.junit.Assert.*;



public class AskTheAudienceTest
{
    private ILifeline lifeline;
    private Question question;



    @Before
    public void setUp() throws Exception
    {
        // luodaan dummy question vastausvaihtoehtoineen
        // oikea vastaus on vastaus 2
        this.question = new Question(1, 2, "Kuka voittaa, karhu vai leijona?", 1);
        this.question.addAnswer( new Answer(1, 1, "Koira") );
        this.question.addAnswer( new Answer(2, 1, "Kissa") );
        this.question.addAnswer( new Answer(3, 1, "Possu") );
        this.question.addAnswer( new Answer(4, 1, "Valtteri") );

        this.lifeline = new AskTheAudience(this.question);
    }



    @Test
    public void getQuestion() throws Exception
    {
        // AskTheAudience ei saa muuttaa questionia
        assertEquals(this.question, this.lifeline.getQuestion());
    }



    @Test
    public void getResult() throws Exception
    {
        // get result ei saa olla null
        assertNotEquals(null, this.lifeline.getResult());
        System.out.println(this.question.getQuestion());
        System.out.println(this.lifeline.getResult());
    }
}