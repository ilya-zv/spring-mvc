package ru.zv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zv.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> findAuthorByAuthorName(String authorName);
    Author save(Author author);

    @Modifying
    @Query("update Author a set a.authorName = :authorName where a.authorId = :authorId")
    void updateAuthorNameByAuthorId(@Param("authorId") Long authorId, @Param("authorName") String authorName);

    void deleteByAuthorId(Long id);
    void deleteByAuthorName(String name);
}
