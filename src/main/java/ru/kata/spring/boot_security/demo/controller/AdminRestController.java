package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.PublicKey;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserServiceImpl userServiceImpl;

    private final RoleServiceImpl roleService;

    public AdminRestController(UserServiceImpl userServiceImpl, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.findAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userServiceImpl.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userServiceImpl.findByIdUsers(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userServiceImpl.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/current_user")
    public ResponseEntity <User> showCurrentUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        userServiceImpl.updateUser(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        userServiceImpl.deleteByIdUsers(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}





//@RestController
//@RequestMapping("/api")
//public class AdminRestController {
//
//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public AdminRestController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("/test")
//    public String sayHello() {
//        return "Hello!";
//    }
//
//    @GetMapping("/users")
//    public List<User> showAllUsers() {
//        return userService.findAllUsers();
//    }
//
//    @GetMapping("/users/{id}")
//    public User showUserBuId(@PathVariable("id") long id) {
//        return userService.findByIdUsers(id);
//    }
//
//    @PostMapping("/users")
//    public User createNewUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return user;
//    }

//    @GetMapping("/users/current_user")
//    public ResponseEntity <User> showCurrentUser(@AuthenticationPrincipal User user) {
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
//        userServiceImpl.updateUser(id, user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
//        userServiceImpl.deleteByIdUsers(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }


//}
