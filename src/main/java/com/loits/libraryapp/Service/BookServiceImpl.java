package com.loits.libraryapp.Service;

import com.loits.libraryapp.domain.Book;
import com.loits.libraryapp.repository.BookRepository;
import com.loits.libraryapp.resource.BookResource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
//@Transactional(rollbackFor=Exception.class)
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public String saveBook(BookResource bookResource) {

        String status1 = "Brand-new";
        String status2 = "Used";

        Book book = new Book();

        if(bookResource.getName().isEmpty())
            return "Book name is required";
        else if (bookResource.getCode().isEmpty())
            return "Book code is required";
        else if(bookResource.getDescription().isEmpty())
            return "Description is required";
        else if(bookResource.getAuthorName().isEmpty())
            return "Author name is required";
        else if(bookResource.getStatus().isEmpty())
            return "Status is required";
        else if(bookResource.getStatus().equalsIgnoreCase(status1)||bookResource.getStatus().equalsIgnoreCase(status2)) {
            bookRepository.saveAndFlush(book);
            return "Record created successfully";
        }
        return null;
    }

    @Override
    public String updateBook(int id, BookResource bookResource) {

        String status1 = "Brand-new";
        String status2 = "Used";

        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setBookName(bookResource.getName());
            book.setBookCode(bookResource.getCode());
            book.setBookDescription(bookResource.getDescription());
            book.setBookAuthor(bookResource.getAuthorName());
            book.setBookStatus(bookResource.getStatus());

            bookRepository.saveAndFlush(book);

            return "Record updated successfully";
        }
        else
            return "Record not found";
    }

    @Override
    public String deleteBook(int id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent()){
            bookRepository.delete(bookOpt.get());
            return "Book is deleted successfully. Book id : " + id;
        }
        else
            return "Record not found";
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> getByCode(String code) {
        return bookRepository.findByCode(code);
    }

    @Override
    public List<Book> getByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    @Override
    public List<Book> getByStatus(String status) {
        return bookRepository.findByStatus(status);
    }
}
