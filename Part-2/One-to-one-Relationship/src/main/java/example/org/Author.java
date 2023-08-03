package example.org;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    private String AuthorId;
    private String AuthorName;


    @OneToOne
    private Book book;


    public Author(){

    }

    public Author(String authorId, String authorName, Book book) {
        AuthorId = authorId;
        AuthorName = authorName;
        this.book = book;
    }

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String authorId) {
        AuthorId = authorId;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
