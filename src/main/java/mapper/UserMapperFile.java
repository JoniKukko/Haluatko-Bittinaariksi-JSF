package mapper;

import interfaces.IUserMapper;
import model.User;
import model.Users;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



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


    // Tässä kirjoitetaan tiedostoon.
    public void saveUsers()
    {
        // Luodaan repositorysta JSON-objekti
        JSONObject scoreboard = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < this.repository.getUsers().size(); i++)
        {
            JSONObject userInJson = new JSONObject();
            userInJson.put("Name", this.repository.getUsers().get(i).getName());
            userInJson.put("Score", this.repository.getUsers().get(i).getScore());

            jsonArray.add(userInJson);
        }

        scoreboard.put("Scoreboard", jsonArray);



        // Kirjoitetaan yllä luotu objekti tiedostoon

        try
        {
            FileWriter file = new FileWriter("src/data/score.json");

            file.write(scoreboard.toJSONString());

            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Users getRepository()
    {
        return repository;
    }
}
