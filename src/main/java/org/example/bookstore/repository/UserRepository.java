package org.example.bookstore.repository;

import org.example.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User save(User user);
}


//public interface UserRepository extends JpaRepository<User, Long> {
// U
// Optional<User> findByUsername(String username);
