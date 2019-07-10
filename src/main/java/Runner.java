import models.Book;

public class Runner {
    public static void main(String[] args) {
        DaoConcrete daoConcrete = new DaoConcrete();

        Book book1 = new Book("Book1","Author1","isbn1","desc1","g1");
        Book book2 = new Book("Book2","Author2","isbn2","desc2","g2");
        Book book3 = new Book("Book3","Author3","isbn3","desc3","g3");
        Book book4 = new Book("Book4","Author4","isbn4","desc4","g4");


        daoConcrete.insertBook(book1);
        daoConcrete.insertBook(book2);
        daoConcrete.insertBook(book3);
        daoConcrete.insertBook(book4);

    }
}
