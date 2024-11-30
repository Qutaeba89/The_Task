package org.grp5.thetask;

public class Check {


    // Checks first if username and password is correct.
    // If no user is found. it returns false.
    // If password does not match, it returns false.
    public static boolean isLoginCredentialsCorrect(String username, String password) {
        User user = PretendDatabase.getUser(username);
        if (user != null)
            return user.getPassword().equals(password);

        return false;
    }


    // Checks if a user exist in the database already.
    public static boolean isUserInDatabase(String username) {
        User user = PretendDatabase.getUser(username);
        return user != null;
    }

}
