package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users/index";
    }
    @GetMapping("/{id}")
        public String showUserById(@PathVariable("id") long id, ModelMap model){
            model.addAttribute("user", userService.getUserById(id));
            return "users/index";
    }

    @GetMapping("/create")
    public String addUser(ModelMap model){
        model.addAttribute("user", new User());
        return "users/create";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUserPage(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/update";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }



    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
