package com.max99.max99.controllers;


import com.max99.max99.dto.UserDTO;
import com.max99.max99.services.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {


   private final UserService userService;

    @PostMapping
    public UserDTO createNewPost(@RequestBody UserDTO inputUser) {
        return userService.createNewUser(inputUser);
    }

    @GetMapping
    public List<UserDTO> getAllUsers()
    {
       return  userService.getAllUsers();
    }

}
