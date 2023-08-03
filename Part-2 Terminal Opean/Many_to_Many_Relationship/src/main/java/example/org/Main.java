package example.org;

import example.org.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Add  Book   \t\t\t  [2] Update Book \n");
        System.out.println("[3] Search Book  \t\t\t [4] Delete Book \n");
        System.out.println("[5]  saveAuthorWithMultipleBooks  \n");

        System.out.print("Enter an option to continue >");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                search();
                break;
            case 4:
                delete();
                break;
            case 5:
                saveAuthorWithMultipleBooks();
                break;
            default:
                homePage();
        }
    }

    private static void homePage() {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Add  Book   \t\t\t  [2] Update Book \n");
        System.out.println("[3] Search Book  \t\t\t [4] Delete Book \n");


        System.out.print("Enter an option to continue >");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                search();
                break;
            case 4:
                delete();
                break;
            case 5:
                saveAuthorWithMultipleBooks();
                break;
            default:
                homePage();

        }

    }
    private static void add() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        SAVE MANAGEMENT                     |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());

        System.out.print("Input book name : ");
        book.setName(scanner.next());


        System.out.print("Input book price : ");
        book.setPrice(scanner.nextDouble());

        Author author=new Author();
        System.out.print("Input author id : ");
        author.setId(scanner.next());

        System.out.print("Input author name : ");
        author.setName(scanner.next());

        List<Book> books=new ArrayList<>();
        books.add(book);

        List<Author>authors=new ArrayList<>();
        authors.add(author);

        author.setBooks(books);
        book.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(author);
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the Add Manage Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            add();
        } else {
            homePage();
        }


    }

    private static void update() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        UPDATE MANAGEMENT                     |");
        System.out.println("+-------------------------------------------------------------+\n\n");
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());

        System.out.print("Input book name : ");
        book.setName(scanner.next());

        System.out.print("Input book price : ");
        book.setPrice(scanner.nextDouble());

        Author author=new Author();
        System.out.print("Input Author id : ");
        author.setId(scanner.next());

        System.out.print("Input Author name : ");
        author.setName(scanner.next());

        List<Book> books=new ArrayList<>();
        books.add(book);

        List<Author>authors=new ArrayList<>();
        authors.add(author);

        author.setBooks(books);
        book.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        session.update(author);
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the  Update Manage Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            update();
        } else {
            homePage();
        }
    }


    private static void search() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        SEARCH MANAGEMENT                     |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Input book id : ");
        book.setId(scanner.next());

        Author author=new Author();
        System.out.print("Input Author id : ");
        author.setId(scanner.next());
        List<Book> books=new ArrayList<>();
        books.add(book);

        List<Author>authors=new ArrayList<>();
        authors.add(author);

        author.setBooks(books);
        book.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.print("Input want book id : ");
        book = session.get(Book.class,scanner.next());
        System.out.println(book.getId()+"  "+book.getName()+"  "+book.getPrice());

        System.out.print("Input want Author id : ");
        author=session.get(Author.class,scanner.next());
        System.out.println(author.getId()+"  "+author.getName());
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the Book Search Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            search();
        } else {
            homePage();
        }
    }


    private static void delete() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        DELETE MANAGEMENT                     |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());

        Author author=new Author();
        System.out.print("Input Author id : ");
        author.setId(scanner.next());

        List<Book> books=new ArrayList<>();
        books.add(book);

        List<Author>authors=new ArrayList<>();
        authors.add(author);

        author.setBooks(books);
        book.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();

        System.out.print("\nDo you want to go to the Book Delete Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            delete();
        } else {
            homePage();
        }
    }
    private static void saveAuthorWithMultipleBooks() {
        Scanner input = new Scanner(System.in);
        Book book = new Book();
        Book book1 = new Book();
        Author author = new Author();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Author Id: ");
        author.setId(input.next());
        System.out.print("Enter Author Name: ");
        author.setName(input.next());

        System.out.print("How many books do you want to add for this author? ");
        int numBooks = input.nextInt();

        for (int i = 0; i < numBooks; i++) {
            Book book2 = new Book();
            System.out.print("Enter Book Id: ");
            book.setId(input.next());
            System.out.print("Enter Book Name: ");
            book.setName(input.next());
            System.out.print("Enter Book Price: ");
            book.setPrice(input.nextDouble());

            add();


        }
    }

    private static void clearConsole() {

    }
}
