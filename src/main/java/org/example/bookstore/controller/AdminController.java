package org.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/adminpanel")
    public String adminpanel() {
        return "adminpanel";
    }
}

//Todo przy rejsetracji dodac napis success tracimy message. Return message w formie oopcji w url prazez model nie przejdzie
// jedna z metod to uzyc redirect atributes
