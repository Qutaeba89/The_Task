package org.grp5.thetask;

public class Check {
 /*check username and password  
     against the correct username and password*/
     public static boolean isCorrectLogin(String username, String password) {
                
        return "testUser".equals(username) && "12345".equals(password);
    }

}
