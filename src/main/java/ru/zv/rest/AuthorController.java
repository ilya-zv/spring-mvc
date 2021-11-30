package ru.zv.rest;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String updatePage(@RequestParam("id") Long id, Model model) {
        Author author = authorService.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("author", author);
        return "edit";
    }

    @PostMapping ("/edit")
    public String updateAuthor(Author author, Model model) {
        System.out.println(author.getAuthorId());
        System.out.println(author.getAuthorName());
        authorService.updateNameAuthorById(author.getAuthorId(), author.getAuthorName());
        return "redirect:/authors";
    }

    @GetMapping("/author-create")
    public String createAuthorForm(Author author) {
        return "author-create";
    }

    @RequestMapping(value = "/author-create", method = RequestMethod.POST)
    public String createAuthor(@ModelAttribute(value = "author") Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/author-delete")
    public String deleteAuthor(@RequestParam("id") Long id) {
        authorService.removeAuthorById(id);
        return "redirect:/authors";
    }


}
