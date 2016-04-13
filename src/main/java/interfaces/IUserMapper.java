package interfaces;


import model.User;
import model.Users;

public interface IUserMapper
{
    void saveUser(User user);
    Users loadUsers();

    Users getRepository();

    void saveUsers();
}
