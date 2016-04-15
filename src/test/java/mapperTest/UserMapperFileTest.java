package mapperTest;

import interfaces.IUserMapper;
import mapper.UserMapperFile;
import model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;



public class UserMapperFileTest {

    private IUserMapper userMapper;



    @Before
    public void setUp() throws Exception
    {
        this.userMapper = new UserMapperFile();
    }



    @Test
    public void getScores() throws Exception
    {

        for (int i = 0; i < this.userMapper.getRepository().getUsers().size(); i++)
        {
            System.out.println(this.userMapper.getRepository().getUsers().get(i).getName() + " : " + userMapper.getRepository().getUsers().get(i).getScore());
        }

        assertNotEquals(null, this.userMapper.getRepository());
    }



    @Test
    public void saveScores() throws Exception
    {
        // Lisätään yks uus käyttäjä.
        // Vaihda näitä mielellään kun ajat testin niin tulee uusia rivejä eikä samoja.
        this.userMapper.saveUser(new User("Minna", 100));

        this.userMapper.saveUsers();

        assertNotEquals(null, this.userMapper.getRepository());
    }
}