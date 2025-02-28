package com.example.Controller;

import com.example.UserService.UserService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que essa classe é um controlador REST
@RequestMapping("/Usuarios")
public class UserControl {

    @Autowired
    private UserService userService;

    @PostMapping("/Cadastrar")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
