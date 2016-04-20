package interfaces;


import model.User;
import model.Users;

import java.io.IOException;

public interface IUserMapper
{
    void saveUser(User user);

    Users loadUsers();

    Users getRepository();

    void saveUsers() throws IOException;
}
