package com.course.spring6webapp.controllers;

import com.course.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllers {
    private final BookService bookService;

    public BookControllers(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
