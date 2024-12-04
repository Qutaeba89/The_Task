package org.grp5.thetask.Controllers;


import org.grp5.thetask.Check;
import org.grp5.thetask.PretendDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.grp5.thetask.Constants.Attributes.ERROR;
import static org.grp5.thetask.Constants.Attributes.MESSAGE;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirmePassword, Model model) {
        if (Check.isUserInDatabase(username)) {
            model.addAttribute(ERROR, "Användarnamnet finns redan!");
            return "register";
        }

        if (!password.equals(confirmePassword)) {
            model.addAttribute(ERROR, "Lösenorden matchar inte varandra!");
            return "register";
        }

        PretendDatabase.addUser(username, password);
        model.addAttribute(MESSAGE, "Registrering Lyckades! Logga in.");
        return "register";
    }
}
