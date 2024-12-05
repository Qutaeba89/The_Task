import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.grp5.thetask.Constants.Attributes.*;

@Controller
public class LoginController {

    // Show login page both /login and /
    // Checks for session username
    // If it exists, redirect to dashboard
    // else, return login page.
    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request) {

        if (Check.isUserAlreadyLoggedIn(request))
            return "redirect:/dashboard";

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, Model model, @RequestParam String username, @RequestParam String password) {
        // Checks if user exist, then if pw matches.
        // else sends error msg.
        if (Check.isLoginCredentialsCorrect(username, password)) {
            session.setAttribute(USERNAME, username);
            return "redirect:/dashboard";
        }

        model.addAttribute(ERROR, "Fel användarnamn eller lösenord.");
        return "login";
    }

    // Logout contoller if needed
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        session.invalidate();  // deleting session
        return "redirect:/login";
    }
}
