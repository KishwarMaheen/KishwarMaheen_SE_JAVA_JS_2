package com.kishwar.kishwarmaheen_se_java_js_2.controller;

import com.kishwar.kishwarmaheen_se_java_js_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @CrossOrigin
    public int createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email){
        return userService.createUser(username, password, email);
    }

    @GetMapping
    @CrossOrigin
    public boolean login(@RequestParam String username, @RequestParam String password){
        return userService.login(username, password);
    }
}
