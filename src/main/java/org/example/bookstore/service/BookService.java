package org.example.bookstore.service;

import jakarta.transaction.Transactional;
import org.example.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookDAO bookDAO;

    @Autowired
    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public Optional<Book> getById(int id) {
        return bookDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Book book) {
        bookDAO.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bookDAO.delete(id);
    }
}