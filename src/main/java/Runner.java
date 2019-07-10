import models.Book;

public class Runner {
    public static void main(String[] args) {
        DaoConcrete daoConcrete = new DaoConcrete();

        Book book = new Book("asdf","asdf","asdf","asdf","asdf");

        daoConcrete.insertBook(book);

    }
}
