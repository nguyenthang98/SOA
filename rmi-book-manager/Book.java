import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private String isbn;

    Book() {}
    Book(int id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        return String.format("%d, %s, %s, %s", this.id, this.title, this.author, this.isbn);
    }
}
