package mapper;

import interfaces.IUserMapper;
import model.User;
import model.Users;

import java.io.*;
import java.util.ArrayList;
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
        Users users = new Users();
        List<User> userList = new ArrayList<User>();

        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("src/data/score.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // split the line on your splitter(s)
                String[] splitted = strLine.split("|"); // here - is used as the delimiter
                userList.add(new User(splitted[0], Integer.parseInt(splitted[1])));
            }

            users = new Users(userList);

            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return users;

    }


    // Tässä kirjoitetaan tiedostoon.
    public void saveUsers() throws IOException
    {
        FileWriter fw = new FileWriter("src/data/score.txt");

        for (int i = 0; i < this.repository.getUsers().size(); i++) {
            fw.write(this.repository.getUsers().get(i).getName() + "|" + this.repository.getUsers().get(i).getScore());
        }

        fw.close();

    }



    public Users getRepository()
    {
        return repository;
    }
}
