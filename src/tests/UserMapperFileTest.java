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

        System.out.println(userMapper.getRepository().getUsers().get(0).getName() + " : " + userMapper.getRepository().getUsers().get(0).getScore());
        System.out.println(userMapper.getRepository().getUsers().get(1).getName() + " : " + userMapper.getRepository().getUsers().get(1).getScore());

        assertNotEquals(null, userMapper.getRepository());
    }
}
