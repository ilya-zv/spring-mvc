package ru.zv.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zv.domain.Author;
import ru.zv.service.reposervice.AuthorService;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String allAuthor(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "author";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        Author author = authorService.findById(id).orElseThrow(NullPointerException::new);
        model.addAttribute("author", author);
        return "edit";
    }

    @PostMapping("/edit")
    public String createAuthor(Author author, Model model) {
        Author saved = authorService.save(author);
        model.addAttribute(saved);
        return "edit";
    }

    @GetMapping("/author-create")
    public String createAuthorForm(Author author) {
        return "author-create";
    }

    @PostMapping("/author-create")
    public String createAuthor(Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/author-delete")
    public String deleteAuthor(@RequestParam("id") Long id) {
        authorService.removeAuthorById(id);
        return "redirect:/authors";
    }


}
