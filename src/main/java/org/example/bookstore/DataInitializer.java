package org.example.bookstore;

import org.example.bookstore.model.Book;
import org.example.bookstore.service.IBookService;
import org.example.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private IBookService bookService;

    @Override
    public void run(String... args) throws Exception {
        userService.createAdminUser();
        if (bookService.getAll().isEmpty()) {

            bookService.saveOrUpdate(new Book("JAVA", "MAREK", new BigDecimal("29.99"), 10));
            bookService.saveOrUpdate(new Book("SPRING", "Wojtek", new BigDecimal("19.99"), 15));
            bookService.saveOrUpdate(new Book("C++", "TEST", new BigDecimal("39.99"), 5));
        }
    }
}
