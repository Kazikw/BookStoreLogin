package org.example.bookstore;

import org.example.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {
        userService.createAdminUser();
    }
}
