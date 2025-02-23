package com.platcloud.book_library.controller;

import com.platcloud.book_library.entity.Book;
import com.platcloud.book_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.list();
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/update")
    public String showUpdateBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/books/{id}/update")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.updateById(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.removeById(id);
        return "redirect:/books";
    }
}
