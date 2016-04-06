package tests;


import mapper.IQuestionMapper;
import mapper.QuestionMapperSQL;
import model.Question;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;



public class QuestionMapperSQLTest
{
    @Test
    public void getRandomQuestionByLevel() throws Exception
    {
        IQuestionMapper questionMapper = new QuestionMapperSQL();
        Question question = questionMapper.getRandomQuestionByLevel(1);

        System.out.println(question.toString());

        assertNotEquals(null, question);
    }
}