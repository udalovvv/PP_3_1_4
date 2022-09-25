package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public String showAll(Model model) {
        model.addAttribute("user", userService.showAll());
        return "index";
    }

    @GetMapping("/admin/new")
    public String addUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/admin")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/admin";
    }

//    @DeleteMapping("/user/{id}")
    @GetMapping("/admin/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";
    }



//    @GetMapping("/user/{id}/edit")
    @GetMapping("/user/")
    public String showUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(2));
        return "user";
    }
}
