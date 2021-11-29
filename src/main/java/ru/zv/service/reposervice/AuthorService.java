package ru.zv.service.reposervice;

import ru.zv.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    List<Author> findAll();
    Optional<Author> findById(Long authorId);
    Optional<Author> findByName(String authorName);
    void updateNameAuthorById(Long authorId, String authorName);
    void removeAuthorById(Long authorId);
    void removeAuthorByName(String authorName);
}
