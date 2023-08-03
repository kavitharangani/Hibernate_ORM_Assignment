package example.org;

import example.org.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Add  Book   \t\t\t  [2] Update Book \n");
        System.out.println("[3] Search Book  \t\t\t [4] Delete Book \n");


        System.out.print("Enter an option to continue >");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                addBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                searchBook();
                break;
            case 4:
                deleteBook();
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
                addBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                searchBook();
                break;
            case 4:
                deleteBook();
            default:
                homePage();
        }

    }
    private static void addBook() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        ADD BOOK                      |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());

        System.out.print("Input book name : ");
        book.setName(scanner.next());

        System.out.print("Input book price : ");
        book.setPrice(scanner.nextDouble());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the Book Manage Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            addBook();
        } else {
            homePage();
        }


    }

    private static void updateBook() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        UPDATE BOOK                      |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());

        System.out.print("Input book name : ");
        book.setName(scanner.next());

        System.out.print("Input book price : ");
        book.setPrice(scanner.nextDouble());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the Book Update Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            updateBook();
        } else {
            homePage();
        }
    }


    private static void searchBook() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        SEARCH BOOK                      |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Input book id : ");
        book.setId(scanner.next());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.print("Input want book id : ");
        book = session.get(Book.class,scanner.next());
        System.out.println(book.getId()+"  "+book.getName()+"  "+book.getPrice());
        transaction.commit();
        session.close();

        System.out.print("\nDo you want to go to the Book Search Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            addBook();
        } else {
            homePage();
        }
    }


    private static void deleteBook() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                        DELETE BOOK                      |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Input book id : ");
        book.setId(scanner.next());


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(book);
        transaction.commit();

        System.out.print("\nDo you want to go to the Book Delete Page? (y/n)");
        char choice = scanner.next().charAt(0);
        if ((choice == 'y') || (choice == 'Y')) {
            deleteBook();
        } else {
            homePage();
        }
    }


    private static void clearConsole() {
    }
}
