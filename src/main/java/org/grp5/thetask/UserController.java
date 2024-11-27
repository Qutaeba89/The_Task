package org.grp5.thetask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
        private final List<User> users = new ArrayList<>();

      public void registerUser(@RequestParam String username, @RequestParam String password, Model model) {

      }

       public void loginUser(
        @RequestParam String username,
        @RequestParam String password,
        HttpSession session,
        Model model
    ) {


    }

    public void showHomePage(HttpSession session, Model model) {


}

public void logoutUser(HttpSession session) {

    
}
}
