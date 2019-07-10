import daos.BookDao;
import daos.ConnectionFactory;
import models.Book;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DaoConcrete implements BookDao {
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
        finally {
            closeConnection(connection);
        }
        return null;
    }

    public Set<Book> getAllBooks() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            Set<Book> books = new HashSet<Book>();
            while (resultSet.next()) {
                Book book = extractBookFromResultSet(resultSet);
                books.add(book);
            }
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }

        return null;
    }

    public Book getBookByTitle(String title) {
        Connection connection  = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
        return null;
    }

    public boolean insertBook(Book book) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books VALUES (NULL,?,?,?,?,?)");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getIsbn());
            preparedStatement.setString(4,book.getDescription());
            preparedStatement.setString(5,book.getGenre());
            int i = preparedStatement.executeUpdate();

            if (i == 1) {return true;}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
        return false;
    }

    public boolean updateBook(Book book) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET title=?, author=?,isbn=?,description=?,genre=? WHERE book_id=?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getIsbn());
            preparedStatement.setString(4,book.getDescription());
            preparedStatement.setString(5,book.getGenre());
            preparedStatement.setInt(6,book.getBook_id());
            int i = preparedStatement.executeUpdate();

            if (i == 1) {return true;}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }

        return false;
    }

    public boolean deleteBook(Integer book_id) {
        Connection connection = ConnectionFactory.getConnection();
        try {

            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM books WHERE book_id="+book_id);

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
        return false;
    }
    //added extra method extractBookFromResultSet ()
    /*It's more convenient to make a separate method to extract user data from result set as we'd use it in many methods.

The new method would throw SQLException and would be provate to limit access only inside the class:*/

    protected Book extractBookFromResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setDescription(rs.getString("description"));
        book.setGenre(rs.getString("genre"));
        return book;
    }

    private void closeConnection (Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
