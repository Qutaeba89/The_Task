package org.grp5.thetask.Controllers;  

import jakarta.servlet.http.HttpSession;
import org.grp5.thetask.User;
import org.grp5.thetask.PretendDatabase; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Show login page both /login and /
    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String showLoginPage() {
        return "login"; 
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, Model model, @RequestParam String username, @RequestParam String password) {
        // controll un. and pw. loop through list from PD.
        //send to dashboard if equals
        for (User user : PretendDatabase.getUsers()) {
            if (user.getUsername().equals(username) && user.isPasswordCorrect(password)) {
                session.setAttribute("username", username);
                return "redirect:/dashboard";  
            } 
        } 
        model.addAttribute("error", "Fel användarnamn eller lösenord.");
        return "login"; 
    }

    // Logout contoller if needed
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        session.invalidate();  // deleting session
        return "redirect:/login"; 
    }
}
