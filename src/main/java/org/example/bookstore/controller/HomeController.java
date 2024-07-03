package org.example.bookstore.controller;

import org.example.bookstore.model.User;
import org.example.bookstore.service.BookService;
import org.example.bookstore.service.IBookDAO;
import org.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    private final BookService bookService;
//    @Autowired
//    public HomeController(BookService bookService, User user) {
//        this.bookService = bookService; this.user = user;
//    }
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("books", bookService.getAll());
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "index-admin";
        } else {
            return "index";
        }
//        return "index";
    }

@RequestMapping(path = {"/index","/"}, method = RequestMethod.GET)
public String main(Model model){

    return "index";
    }

}

