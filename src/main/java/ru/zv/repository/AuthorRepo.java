package ru.zv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zv.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> findAuthorByAuthorName(String authorName);
    Author save(Author author);
    void deleteByAuthorId(Long id);
    void deleteByAuthorName(String name);
}
