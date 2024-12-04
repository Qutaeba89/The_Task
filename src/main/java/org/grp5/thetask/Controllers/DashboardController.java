package org.grp5.thetask.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.grp5.thetask.Check;
import org.grp5.thetask.ToDos.TodoList;
import org.grp5.thetask.User;
import org.grp5.thetask.PretendDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.grp5.thetask.Constants.Attributes.*;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(HttpSession session, Model model) {
        User currentUser = Check.getUserIfActive(session);
        if (currentUser == null)
            return "redirect:/login";

        model.addAttribute(USERNAME, currentUser.getUsername());
        model.addAttribute(TODO_LISTS, currentUser.getAllTodoLists());
        return "dashboard";
    }

    @PostMapping("/dashboard/createList")
    public String createTodoList(HttpSession session, @RequestParam(LIST_TITLE) String listTitle) {
        User currentUser = Check.getUserIfActive(session);
        if (currentUser == null)
            return "redirect:/login";

        currentUser.createTodoList(listTitle);
        return "redirect:/dashboard";

    }

    @PostMapping("/dashboard/deleteList")
    public String deleteTodoList(HttpSession session, @RequestParam(LIST_ID) int listId) {
        User currentUser = Check.getUserIfActive(session);
        if (currentUser == null)
            return "redirect:/login";

        currentUser.deleteTodoList(listId);
        return "redirect:/dashboard";
    }

    @PostMapping("/dashboard/deleteTask")
    public String deleteTodoTask(HttpSession session, @RequestParam(LIST_ID) int listId, @RequestParam(TASK_ID) int taskId) {
        User currentUser = Check.getUserIfActive(session);
        if (currentUser == null)
            return "redirect:/login";

        // There is a boolean that we could use to check if task were deleted or not.
        // Not required to use it. It could be used for displaying a msg to user:
        // "Task deleted" or "Failed to delete task"
        currentUser.deleteTask(listId, taskId);

        return "redirect:/dashboard";
    }

    // get task by id
    @PostMapping("/dashboard/createTask")
    public String createTask(HttpSession session, @RequestParam(TASK_TITLE) String taskTitle,
                             @RequestParam(LIST_ID) int listId, @RequestParam(DEADLINE) String deadline) {
        User currentUser = Check.getUserIfActive(session);
        if (currentUser == null)
            return "redirect:/login";

        // There is a boolean that we could use to check if task were added or not.
        // Not required to use it. It could be used for displaying a msg to user:
        // "Task created" or "Failed to create task"
        currentUser.addNewTask(taskTitle, listId, deadline);

        return "redirect:/dashboard";
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
