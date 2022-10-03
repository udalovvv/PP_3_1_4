package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Component
public class InitializeUsers {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitializeUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    Role adminRole = new Role("ROLE_ADMIN");
    Role userRole = new Role("ROLE_USER");


    private final List<Role> roles1 = new LinkedList<>(List.of(adminRole, userRole));
    private final List<Role> roles2 = new LinkedList<>(List.of(userRole));


    private final User admin = new User("admin", "admin",  "admin@mail.com", "admin", roles1);
    private final User user = new User("user", "user",  "user@mail.com", "user", roles2);


    @Transactional
    public void init() {
        roleService.save(adminRole);
        roleService.save(userRole);
        userService.save(admin);
        userService.save(user);
    }
}
