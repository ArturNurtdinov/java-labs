import java.io.InputStreamReader;
import java.util.Scanner;

public class Task3 implements TaskContract.Task3 {
    private static Scanner scanner = new Scanner(new InputStreamReader(System.in));

    @Override
    public void printMenu() {
        System.out.println("Type 1 to add book");
        System.out.println("Type 2 to delete book by index");
        System.out.println("Type 3 to find books by number");
        System.out.println("Type 4 to find books by author");
        System.out.println("Type 5 to find books by name");
        System.out.println("Type 6 to find books by releaseDate");
        System.out.println("Type 7 to update book");
        System.out.println("Type 8 to read book by index");
        System.out.println("Type 9 to print all books");
    }

    @Override
    public Book readBook() {
        System.out.println("Please insert a book: ");
        System.out.print("Number = ");
        int number = scanner.nextInt();
        System.out.print("Author = ");
        String author = scanner.next();
        System.out.print("Name = ");
        String name = scanner.next();
        System.out.print("Release date = ");
        int releaseDate = scanner.nextInt();
        return new Book(number, author, name, releaseDate);
    }

    @Override
    public int readCode() {
        return scanner.nextInt();
    }

    @Override
    public int readIndex() {
        return scanner.nextInt();
    }

    @Override
    public int readNumber() {
        return scanner.nextInt();
    }

    @Override
    public String readAuthor() {
        return scanner.next();
    }

    @Override
    public String readName() {
        return scanner.next();
    }

    @Override
    public int readReleaseDate() {
        return scanner.nextInt();
    }
}
