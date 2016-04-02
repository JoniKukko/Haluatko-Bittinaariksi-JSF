package model;

import java.util.List;

/**
 * Created by valje on 2.4.2016.
 */

public class Users {
    private List<User> users;



    public Users()
    {
    }


    public Users(List<User> users) {
        this.users = users;
    }



    public List<User> getUsers() {
        return users;
    }



    public void setUsers(List<User> users) {
        this.users = users;
    }



    public void addUser(User user) {
        this.users.add(user);
    }
}
