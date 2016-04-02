package mapper;

import model.User;
import model.Users;

/**
 * Created by valje on 2.4.2016.
 */

public class UserMapper {
    Users repository;                       // Tämä ilmeisesti yleensä Javassa DAO vaan? Repo on vähä C-sharppia, mut iha sama.

    public void saveUser(User user) {
        this.repository.addUser(user);

        // Tässä sitten varmaan kirjoitetaan myös tiedostoon asti koko repository.
    }

    public User loadUsers() {
        User user = null;                   // placeholder
        return user;
    }
}
