package com.practicheskaya.madethat.Controller;

import com.practicheskaya.madethat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.practicheskaya.madethat.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/index")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/index";
    }

    @GetMapping("/index/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/index/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> user = userService.getById(id);
        model.addAttribute("user", user.orElse(new User()));
        return "edit";
    }

    @PostMapping("/index/{id}/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/index";
    }
}
