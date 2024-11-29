package org.grp5.thetask.Controllers;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.grp5.thetask.User;          // Importera User-klassen
 

@Controller
public class UserController {
      private final List<User> users = new ArrayList<>();

      @GetMapping("/register")
      public String registerPage(){
        return "register";
      }
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
