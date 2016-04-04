package tests;

import mapper.IUserMapper;
import mapper.UserMapperFile;
import model.User;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class UserMapperFileTestSave {
    @Test
    public void saveScores() throws Exception
    {
        IUserMapper userMapper = new UserMapperFile();

        // Lisätään yks uus käyttäjä.
        // Vaihda näitä mielellään kun ajat testin niin tulee uusia rivejä eikä samoja.
        userMapper.saveUser(new User("Minna", 100));

        userMapper.saveUsers();

        assertNotEquals(null, userMapper.getRepository());
    }
}
