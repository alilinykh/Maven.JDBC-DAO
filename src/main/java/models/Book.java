package models;
public class Book {
    private Integer book_id;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private String genre;

    public Book() {
    }

    public Book(Integer book_id, String title, String author, String isbn, String describtion, String genre) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = describtion;
        this.genre = genre;
    }

    public Book(String title, String author, String isbn, String describtion, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = describtion;
        this.genre = genre;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
