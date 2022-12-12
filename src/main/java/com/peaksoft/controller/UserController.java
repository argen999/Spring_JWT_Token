package com.peaksoft.controller;

import com.peaksoft.entity.User;
import com.peaksoft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping
    User saveUser(@RequestBody  User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
