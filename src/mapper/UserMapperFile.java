package mapper;



import model.User;
import model.Users;



public class UserMapperFile implements IUserMapper
{
    private Users repository;                       // Tämä ilmeisesti yleensä Javassa DAO vaan? Repo on vähä C-sharppia, mut iha sama.



    public void saveUser(User user)
    {
        this.repository.addUser(user);

        // Tässä sitten varmaan kirjoitetaan myös tiedostoon asti koko repository.
    }



    public Users loadUsers()
    {
        return new Users();
    }
}
