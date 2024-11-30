package org.grp5.thetask.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.grp5.thetask.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class UserController {
      private final List<User> users = new ArrayList<>();

      @GetMapping("/register")
      public String registerPage(){
        return "register";
      }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,@RequestParam String confirmePassword, Model model) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("error", "Användarnamnet finns redan!");
                return "register";
            }
        }
        if(!password.equals(confirmePassword)){
          model.addAttribute("error", "Lösenordet är inte samma!");
          return "register";
      }
        users.add(new User(username, password));
        model.addAttribute("message", "Registrering Lyckades! Logga in.");
        // return "redirect:/login";
        return "register";
    }
}
