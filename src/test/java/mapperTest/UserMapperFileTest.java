package mapperTest;

import interfaces.IUserMapper;
import mapper.UserMapperFile;
import model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotEquals;



public class UserMapperFileTest {

    private IUserMapper userMapper;



    @Before
    public void setUp() throws Exception
    {
        String filename = "score.txt";
        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        this.userMapper = new UserMapperFile(file);
    }



    @Test
    public void getScores() throws Exception
    {

        for (User user : this.userMapper.getRepository().getUsers())
        {
            System.out.println(user.getName() + " : " + user.getScore());
        }

        assertNotEquals(null, this.userMapper.getRepository().getUsers());
    }



    @Test
    public void saveScores() throws Exception
    {
        // Lisätään yks uus käyttäjä.
        // Vaihda näitä mielellään kun ajat testin niin tulee uusia rivejä eikä samoja.
        this.userMapper.saveUser(new User("Minna", 100));
        this.userMapper.saveUser(new User("Manu", 300));

        this.userMapper.saveUsers();

        assertNotEquals(null, this.userMapper.getRepository());
    }
}