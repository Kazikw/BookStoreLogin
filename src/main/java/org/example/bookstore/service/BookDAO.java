package org.example.bookstore.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements IBookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private final String GET_ALL_JPQL = "FROM Book";

    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = entityManager.createQuery(GET_ALL_JPQL, Book.class);
        return query.getResultList();
    }

    @Override
    public Optional<Book> getById(int id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public void saveOrUpdate(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }
}