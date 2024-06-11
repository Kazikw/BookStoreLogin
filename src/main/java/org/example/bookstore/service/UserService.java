package org.example.bookstore.service;

import jakarta.transaction.Transactional;
import org.example.bookstore.model.Role;
import org.example.bookstore.model.User;
import org.example.bookstore.repository.RoleRepository;
import org.example.bookstore.repository.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
public interface UserService {
    Optional<User> findByUsername(String username);
    String registerUser(User user);
}