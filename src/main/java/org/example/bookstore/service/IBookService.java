package org.example.bookstore.service;

import org.example.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void saveOrUpdate(Book book);
    Optional<Book> getById(int id);
    List<Book> getAll();
    void delete(int id);
}
