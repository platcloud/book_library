package com.platcloud.book_library.controller;

import com.platcloud.book_library.entity.Book;
import com.platcloud.book_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.list();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // 修改此处的 @PostMapping 注解
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        boolean saved = bookService.save(book);
        if (saved) {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save book", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        Book updatedBook = bookService.updateById(book)? book : null;
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.removeById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}