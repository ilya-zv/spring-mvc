package ru.zv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zv.domain.Author;
import ru.zv.service.reposervice.AuthorService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    AuthorService authorService;

    public Main(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostConstruct
    public void init(){
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        author1.setAuthorName("Фет");
        author2.setAuthorName("Булгаков");
        author3.setAuthorName("Пушкин");
        authorService.save(author1);
        authorService.save(author2);
        authorService.save(author3);
    }
}