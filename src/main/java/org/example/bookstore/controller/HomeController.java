package org.example.bookstore.controller;

import org.example.bookstore.service.BookService;
import org.example.bookstore.service.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {
//    private IBookDAO bookService; // todo Trzeba wywalic to najprawdopodobnie <<<<
//private final BookService bookService;
    private final BookService bookService;
    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "index";
    }
//    @GetMapping({"/home","/"})
//        public String home() {
//            return "home";
//        }

//    @RequestMapping(path = {"/main", "/", "/index"}, method = RequestMethod.GET)
@RequestMapping(path = {"/index","/"}, method = RequestMethod.GET)
public String main(Model model){

    return "index";
    }

}

