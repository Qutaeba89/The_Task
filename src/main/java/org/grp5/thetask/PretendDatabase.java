package org.grp5.thetask;

import java.util.ArrayList;

public class PretendDatabase {

    private static final ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin"));
        users.add(new User("Dennis", "hej123"));
        users.add(new User("Farre", "test123"));
        users.add(new User("Qutaiba", "password123"));
        users.add(new User("Niklas", "lol123"));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    // Return a user if a username matches a user in the list.
    // Otherwise, it returns null.
    public static User getUser(String username) {
        for (User user : users)
            if (user.getUsername().equals(username))
                return user;
        return null;
    }


}
