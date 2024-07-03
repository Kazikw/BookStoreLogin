package org.example.bookstore.controller;

import org.example.bookstore.model.Book;
import org.example.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookService.saveOrUpdate(book);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Book book = bookService.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "book-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/home";
    }
}
