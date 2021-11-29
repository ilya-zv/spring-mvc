package ru.zv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;


    @ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "fk_book_id")),
            inverseJoinColumns = @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "fk_author_id")))
    private List<Author> author;

    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", foreignKey = @ForeignKey(name = "fk_genre_id"), table = "book")
    private Genre genre;

}
