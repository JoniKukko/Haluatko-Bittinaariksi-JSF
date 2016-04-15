package mapper;

import interfaces.IUserMapper;
import model.User;
import model.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserMapperFile implements IUserMapper
{
    private Users repository;
    private File file;



    public UserMapperFile(File file)
    {
        this.file = file;
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
            FileInputStream fstream = new FileInputStream(this.file);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // split the line on your splitter(s)
                String[] splitted = strLine.split("\\|"); // here - is used as the delimiter
                userList.add(new User(splitted[0].toString(), Integer.parseInt(splitted[1].toString())));
            }

            users = new Users(userList);

            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error:: " + e.getMessage());
        }

        return users;

    }


    // Tässä kirjoitetaan tiedostoon.
    public void saveUsers() throws IOException
    {
        FileWriter fw = new FileWriter(this.file);
        BufferedWriter out = new BufferedWriter(fw);


        for (User user : this.repository.getUsers())
        {
            out.write(user.getName() + "|" + user.getScore());
            out.newLine();
        }

        out.close();
        fw.close();
    }



    public Users getRepository()
    {
        return repository;
    }
}
