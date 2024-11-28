package org.grp5.thetask.Controllers;  

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";  // Show login page
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, Model model) {
        // input code to verify user equals later
        // now we use a demo user
        session.setAttribute("username", "demoUser");
        return "redirect:/dashboard";  // send to dashboardn
    }

    // Logout contoller if needed
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        session.invalidate();  // delete session
        return "redirect:/login";  // return to login
    }
}
