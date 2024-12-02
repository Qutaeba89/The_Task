package org.grp5.thetask.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.grp5.thetask.User;
import org.grp5.thetask.PretendDatabase;
import org.grp5.thetask.ToDos.TodoList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DashboardController {

    

    @GetMapping("/dashboard")
public String getDashboard(HttpSession session, Model model) {
    String currentUsername = (String) session.getAttribute("username");
    if (currentUsername == null) { 
        return "redirect:/login";
    }

    User currentUser = PretendDatabase.getUser(currentUsername);
    if (currentUser == null) {
        return "redirect:/login";
    }

    model.addAttribute("username", currentUsername);
    model.addAttribute("todoLists", currentUser.getAllTodoLists());
    return "dashboard";
    }

    @PostMapping("/dashboard/createList")
    public String createTodoList(HttpSession session, @RequestParam("title") String listTitle) {
       
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
    
        User currentUser = PretendDatabase.getUser(username);
        if (currentUser == null) {
            return "redirect:/login";
        }
    
        int nextId = currentUser.getAllTodoLists().size() + 1;
    
        currentUser.createTodoList(nextId, listTitle);
    
        return "redirect:/dashboard"; 
    }

    // get task by id
    @PostMapping("/dashboard/createTask")
    public String createTask(HttpSession session, @RequestParam("taskTitle") String taskTitle, @RequestParam("listId") int listId, @RequestParam("deadline") String deadline) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        User currentUser = PretendDatabase.getUser(username);
        if (currentUser == null) {
            return "redirect:/login";
        }

        //get todolist by id
        TodoList todoList = currentUser.getTodoList(listId);
        if (todoList != null) {
           
            long timeInMilliSecDeadline = convertToMilliSeconds(deadline);
            
            // Create new todotask
            long taskId = System.currentTimeMillis(); 
            todoList.createTodoTask(taskId, taskTitle, timeInMilliSecDeadline);
        }

        return "redirect:/dashboard";  
    }

    // converter for deadline time
    private long convertToMilliSeconds(String deadline) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date date = sdf.parse(deadline);
            return date.getTime();
        } catch (Exception e) {
           
            return 0;
        }
    }

    @PostMapping("/logout")
public String logout(HttpServletRequest request) {
    request.getSession().invalidate();
    return "redirect:/login"; 
}

}
