package daos;

import models.Book;

import java.util.Set;

public interface BookDao {
    Book getBook(Integer book_id);
    Set<Book> getAllBooks();
    Book getBookByTitle(String title);
    boolean insertBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer book_id);

}
