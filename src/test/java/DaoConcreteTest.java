import models.Book;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class DaoConcreteTest {
    DaoConcrete daoConcrete = new DaoConcrete();
    Book book;
    Book b;
    Set<Book> books;

    @Before
    public void setUp() throws Exception {
        b = daoConcrete.getBook(1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBook() {
        book = daoConcrete.getBook(2);
        String expected = "Book2";
        String actual = book.getTitle();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllBooks() {
        books = daoConcrete.getAllBooks();
        Integer expected = 4;
        Integer actual = books.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBookByTitle() {
        book = daoConcrete.getBookByTitle("Book2");
        Integer expected = 2;
        Integer actual = book.getBook_id();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void insertBook() {
        Assert.assertTrue(daoConcrete.insertBook(new Book("1","1","1","1","1")));
    }

    @Test
    public void updateBook() {
        b.setGenre("asdf");
        Assert.assertTrue(daoConcrete.updateBook(b));
    }

    @Test
    public void deleteBook() {
        //Assert.assertTrue(daoConcrete.deleteBook());
    }

}