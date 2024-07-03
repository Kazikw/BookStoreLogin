package org.example.bookstore.service;

import jakarta.transaction.Transactional;
import org.example.bookstore.model.Book;
import org.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Optional<Book> getById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }
}
