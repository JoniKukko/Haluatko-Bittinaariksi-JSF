package tests;

import mapper.IUserMapper;
import mapper.UserMapperFile;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class UserMapperFileTest {
    @Test
    public void getScores() throws Exception
    {
        IUserMapper userMapper = new UserMapperFile();

        for (int i = 0; i < userMapper.getRepository().getUsers().size(); i++)
        {
            System.out.println(userMapper.getRepository().getUsers().get(i).getName() + " : " + userMapper.getRepository().getUsers().get(i).getScore());
        }

        assertNotEquals(null, userMapper.getRepository());
    }
}
