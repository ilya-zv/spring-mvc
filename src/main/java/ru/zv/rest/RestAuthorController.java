package ru.zv.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zv.domain.Author;
import ru.zv.service.reposervice.AuthorService;

import java.util.List;

@RestController
public class RestAuthorController {
    private final AuthorService authorService;

    public RestAuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public Author getListAllAuthor(){
        return authorService.findById(1L).get();
    }
}
