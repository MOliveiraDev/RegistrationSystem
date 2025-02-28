package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Repository, Long> {
    static User save(User user) {
        return null;
    }

    User findByEmail(String email); //Buscar email
}
