package com.loits.libraryapp.repository;

import com.loits.libraryapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByName(String name);
    public Optional<Book> findByCode(String code);
    public List<Book> findByAuthorName(String author);
    public List<Book> findByStatus(String status);

}
