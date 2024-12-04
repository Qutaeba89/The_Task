package org.grp5.thetask;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static org.grp5.thetask.Constants.Attributes.USERNAME;

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

    //Checks if it exists, but does not create a new one if not.
    public static boolean isUserAlreadyLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USERNAME) != null;
    }

    public static User getUserIfActive(HttpSession session) {
        String username = session.getAttribute(USERNAME).toString();
        if (username == null)
            return null;

        return PretendDatabase.getUser(username);
    }
}
