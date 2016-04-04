package mapper;

import model.User;
import model.Users;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@SuppressWarnings("unchecked")
public class UserMapperFile implements IUserMapper
{
    private Users repository;                       // Tämä ilmeisesti yleensä Javassa DAO vaan? Repo on vähä C-sharppia, mut iha sama.



    public UserMapperFile()
    {
        this.repository = loadUsers();
    }



    public void saveUser(User user)
    {
        // Lisätään vain uusi käyttäjä repositorioon, EI VIELÄ TIEDOSTOON
        this.repository.addUser(user);
    }


    // Lukee score.json-tiedoston ja hakee sieltä tallennetut pelitulokset
    public Users loadUsers()
    {
        JSONParser parser = new JSONParser();

        Users users = new Users();

        try {

            Object obj = parser.parse(new FileReader("src/data/score.json"));

            JSONObject jsonObject = (JSONObject) obj;

            List<User> userList = new ArrayList<User>();

            JSONArray scoreboard = (JSONArray) jsonObject.get("Scoreboard");
            Iterator i = scoreboard.iterator();

            while (i.hasNext())
            {
                JSONObject user = (JSONObject) i.next();
                userList.add(new User(user.get("Name").toString(), Integer.parseInt(user.get("Score").toString())));
            }

            users = new Users(userList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }



    public void saveUsers()
    {
        // Tässä kirjoitetaan tiedostoon.
    }



    public Users getRepository()
    {
        return repository;
    }
}
