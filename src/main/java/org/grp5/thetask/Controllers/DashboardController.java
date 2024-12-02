package org.grp5.thetask.Controllers;

import jakarta.servlet.http.HttpSession;
import org.grp5.thetask.User;
import org.grp5.thetask.PretendDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(HttpSession session, Model model) {
        String currentUsername = (String) session.getAttribute("username");
        // If the session does not contain a username, redirect to the login page.
        if (currentUsername == null) { 
            return "redirect:/login";
        }
        
        // Fetch the user data from the PretendDatabase using the username.
        User currentUser = PretendDatabase.getUser(currentUsername);
        // If the user does not exist in the database, redirect to the login page.
        if (currentUser == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("username", currentUsername);
        model.addAttribute("todoLists", currentUser.getAllTodoLists());
        return "dashboard";
    }

    @PostMapping("/dashboard/createList")
    public String createTodoList(HttpSession session, @RequestParam("title") String listTitle) {
        // Controll is username is logged in.
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Gets user from pretenddatabase.
        User currentUser = PretendDatabase.getUser(username);
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Fetch the next ID based on the current number of lists
        int nextId = currentUser.getAllTodoLists().size() + 1;

        // Create a new list for the user
        currentUser.createTodoList(nextId, listTitle);

        return "redirect:/dashboard";
    }
    
}
