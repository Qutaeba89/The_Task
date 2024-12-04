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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/dashboard/deleteList")
    public String deleteTodoList(HttpSession session, @RequestParam("listId") int listId) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User currenUser = PretendDatabase.getUser(username);
        if (currenUser == null) {
            return "redirect:/login";
        }
        currenUser.deleteTodoList(listId);
        return "redirect:/dashboard";
    }

    @PostMapping("/dashboard/deleteTask")
    public String deleteTodoTask(HttpSession session, @RequestParam("listId") int listId,
            @RequestParam("taskId") long taskId) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User currenUser = PretendDatabase.getUser(username);
        if (currenUser == null) {
            return "redirect:/login";
        }
        TodoList todoList = currenUser.getTodoList(listId);
        if (todoList != null) {
            todoList.getTasks().removeIf(task -> task.getTaskId() == taskId);
        }
        return "redirect:/dashboard";
    }

    // get task by id
    @PostMapping("/dashboard/createTask")
    public String createTask(HttpSession session, @RequestParam("taskTitle") String taskTitle,
            @RequestParam("listId") int listId, @RequestParam("deadline") String deadline) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        User currentUser = PretendDatabase.getUser(username);
        if (currentUser == null) {
            return "redirect:/login";
        }

        // get todolist by id
        TodoList todoList = currentUser.getTodoList(listId);
        if (todoList != null) {
            // set to -1 if input not provided
            long timeInMilliSecDeadline = -1;
            // if input then this:
            if (deadline != null && !deadline.isEmpty()) {
                timeInMilliSecDeadline = convertToMilliSeconds(deadline);
            }

            // Create new todotask
            long taskId = System.currentTimeMillis();
            todoList.createTodoTask(taskId, taskTitle, timeInMilliSecDeadline);
        }

        return "redirect:/dashboard";
    }

    // converter for deadline time
    private long convertToMilliSeconds(String deadline) {
        if (deadline == null || deadline.isEmpty()) {
            return -1; // set -1 to return no dealine fooling the standard
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date date = sdf.parse(deadline);
            return date.getTime();
        } catch (Exception e) {

            return -1; // if we get error default to no deadline
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        request.getSession().invalidate();
        redirectAttributes.addFlashAttribute("message","Välkommen åter!");
        return "redirect:/login";
    }

}
