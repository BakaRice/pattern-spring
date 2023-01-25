package com.ricemarch.patternspring.controller;

import com.ricemarch.patternspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/suggest")
    public List<String> suggestRequirement(@RequestParam String username) {

        return userService.suggestRequirement(username);
    }
}
