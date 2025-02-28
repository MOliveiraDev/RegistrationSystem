package com.example.UserService;

import com.example.model.User;
import com.example.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private Repository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 

    public User registerUser(User user) {

        String encodedPassword = passwordEncoder.encode(user.getSenha());
        user.setSenha(encodedPassword);

        return Repository.save(user);
    }
}
