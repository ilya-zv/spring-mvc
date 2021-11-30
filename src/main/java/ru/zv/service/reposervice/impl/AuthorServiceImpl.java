package ru.zv.service.reposervice.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zv.domain.Author;
import ru.zv.repository.AuthorRepo;
import ru.zv.service.reposervice.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author save(Author author) {
        author.setAuthorName(author.getAuthorName());
        return authorRepo.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(Long authorId) {
        return authorRepo.findById(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findByName(String authorName) {
        return authorRepo.findAuthorByAuthorName(authorName);
    }

    @Override
    @Transactional
    public void updateNameAuthorById(Long authorId, String authorName) {
        authorRepo.updateAuthorNameByAuthorId(authorId, authorName);
    }

    @Override
    @Transactional
    public void removeAuthorById(Long authorId) {
        authorRepo.deleteByAuthorId(authorId);
    }

    @Override
    public void removeAuthorByName(String authorName) {
        authorRepo.deleteByAuthorName(authorName);
    }
}
