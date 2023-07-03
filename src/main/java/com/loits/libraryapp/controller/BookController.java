package com.loits.libraryapp.controller;

import com.loits.libraryapp.Service.BookService;
import com.loits.libraryapp.domain.Book;
import com.loits.libraryapp.resource.BookResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/library-detail")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/save")
    public String saveBookDetails(@RequestBody BookResource bookResource){
        return bookService.saveBook(bookResource);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteBookDetails(@PathVariable int id){
        return bookService.deleteBook(id);
    }

    @GetMapping(value = "/get-all")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Optional<Book> getById(@PathVariable int id){
        return bookService.getById(id);
    }

    @GetMapping(value = "/get-by-code/{code}")
    public Optional<Book> getByCode(@PathVariable String code){
        return bookService.getByCode(code);
    }

    @GetMapping(value = "/get-by-authorName/{authorName}")
    public List<Book> getByAuthorName(@PathVariable String authorName){
        return bookService.getByAuthorName(authorName);
    }

    @GetMapping(value = "/get-by-status/{status}")
    public List<Book> getByStatus(@PathVariable String status){
        return bookService.getByStatus(status);
    }

    @PutMapping(value = "/update/{id}")
    public String saveBookDetails(@PathVariable int id, @RequestBody BookResource bookResource){
        return bookService.updateBook(id, bookResource);
    }
}
