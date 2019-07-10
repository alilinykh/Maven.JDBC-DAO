import daos.BookDao;
import daos.ConnectionFactory;
import models.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class Dao implements BookDao {
    public Book getBook(Integer book_id) {
        Connection connection  = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books WHERE book_id = " + book_id);
            if(resultSet.next()) {
                return extractBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Book> getAllBooks() {
        return null;
    }

    public Book getBookByTitle(String title) {
        return null;
    }

    public boolean insertBook(Book book) {
        return false;
    }

    public boolean updateBook(Book book) {
        return false;
    }

    public boolean deleteBook(Integer book_id) {
        return false;
    }
    //aded extra method extractBookFromResultSet ()
    /*It's more convenient to make a separate method to extract user data from result set as we'd use it in many methods.

The new method would throw SQLException and would be provate to limit access only inside the class:*/

    private Book extractBookFromResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setDescription(rs.getString("description"));
        book.setGenre(rs.getString("genre"));
        return book;
    }
}
