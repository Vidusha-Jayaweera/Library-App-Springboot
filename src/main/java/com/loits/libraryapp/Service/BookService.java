package com.loits.libraryapp.Service;

import com.loits.libraryapp.domain.Book;
import com.loits.libraryapp.resource.BookResource;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public String saveBook(BookResource bookResource);

    public String updateBook(int id, BookResource bookResource);

    public String deleteBook(int id);

    public List<Book>getAll();

    public Optional<Book>getById(int id);

    public List<Book>getByName(String name);

    public Optional<Book>getByCode(String code);

    public List<Book>getByAuthorName(String authorName);

    public List<Book>getByStatus(String status);
}
