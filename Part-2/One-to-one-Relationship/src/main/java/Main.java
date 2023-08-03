
import example.org.entity.Author;
import example.org.entity.Book;
import example.org.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Book book= new Book();
        book.setId("B001");
        book.setName("Hathpana");
        book.setPrice(500.00);

        Book book1= new Book();
        book1.setId("B002");
        book1.setName("Abayaluwo");
        book1.setPrice(800.00);

        Author author=new Author();
        author.setAuthorId("A001");
        author.setAuthorName("KumarathungaMunidasa");

        Author author1=new Author();
        author1.setAuthorId("A002");
        author1.setAuthorName("Martin Wickramasinha");


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);
        transaction.commit();
        session.close();


    }
}
