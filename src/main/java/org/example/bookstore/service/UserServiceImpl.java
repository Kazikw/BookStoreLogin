package org.example.bookstore.service;

import jakarta.transaction.Transactional;
import org.example.bookstore.model.Role;
import org.example.bookstore.model.User;
import org.example.bookstore.repository.RoleRepository;
import org.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Transactional
    @Override
    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "failure";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("USER").orElse(null);
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole); // Zapisz nową rolę
        }
        user.getRoles().add(userRole);
        userRepository.save(user);
        return "success";
    }

//    @Transactional
//    @Override
//    public String registerUser(User user) {
//        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//            return "failure";
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role userRole = roleRepository.findByName("USER").orElse(null);
//        if (userRole != null) {
//            user.getRoles().add(userRole);
//        } else {
//            Role role = new Role();
//            role.setName("USER");
//            user.getRoles().add(role);
//        }
//        userRepository.save(user);
//        return "success";
//    }

    @Transactional
    public void createAdminUser() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin1234"));
            Role adminRole = roleRepository.findByName("ADMIN").orElseGet(() -> {
                Role role = new Role();
                role.setName("ADMIN");
                return roleRepository.save(role);
            });
            admin.getRoles().add(adminRole);
            userRepository.save(admin);
        }
    }
}
