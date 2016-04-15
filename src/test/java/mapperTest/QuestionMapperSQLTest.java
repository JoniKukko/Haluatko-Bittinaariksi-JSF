package mapperTest;

import interfaces.IQuestionMapper;
import mapper.QuestionMapperSQL;
import model.Question;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;



public class QuestionMapperSQLTest
{
    private IQuestionMapper questionMapper;



    @Before
    public void setUp() throws Exception
    {
        this.questionMapper = new QuestionMapperSQL();
    }



    @Test
    public void getRandomQuestionByLevel() throws Exception
    {
        Question question = this.questionMapper.getRandomQuestionByLevel(1);

        System.out.println(question.toString());

        assertNotEquals(null, question);
    }
}