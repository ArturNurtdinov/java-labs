import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 implements TaskContract.Task3 {
    private static Scanner scanner = new Scanner(new InputStreamReader(System.in));

    @Override
    public void startMenu(ArrayList<Book> bookArrayList) {
        System.out.println("Type 1 to add book");
        System.out.println("Type 2 to delete book by index");
        System.out.println("Type 3 to find books by number");
        System.out.println("Type 4 to find books by author");
        System.out.println("Type 5 to find books by name");
        System.out.println("Type 6 to find books by releaseDate");
        System.out.println("Type 7 to update book");
        System.out.println("Type 8 to read book by index");
        System.out.println("Type 9 to print all books");
        BookList books = new BookList(bookArrayList);
        while (true) {
            int code = this.readCode();
            switch (code) {
                case 1:
                    books.add(readBook());
                    System.out.println("Done! Next command: ");
                    break;
                case 2:
                    System.out.println("Please type book's index to delete it: ");
                    books.delete(readIndex());
                    System.out.println("Done! Next command: ");
                    break;
                case 3:
                    System.out.println("Please type book's number: ");
                    BookList byNumber = new BookList(books.getByNumber(readNumber()));
                    byNumber.printBooks();
                    System.out.println("Done! Next command: ");
                    break;
                case 4:
                    System.out.println("Please type book's author: ");
                    BookList byAuthor = new BookList(books.getByAuthor(readAuthor()));
                    byAuthor.printBooks();
                    System.out.println("Done! Next command: ");
                    break;
                case 5:
                    System.out.println("Please type book's name: ");
                    BookList byName = new BookList(books.getByName(readName()));
                    byName.printBooks();
                    System.out.println("Done! Next command: ");
                    break;
                case 6:
                    System.out.println("Please type book's release date: ");
                    BookList byDate = new BookList(books.getByReleaseDate(readReleaseDate()));
                    byDate.printBooks();
                    System.out.println("Done! Next command: ");
                    break;
                case 7:
                    System.out.println("Please type book's index to update it: ");
                    int indexToUpdate = readIndex();
                    books.update(indexToUpdate, readBook());
                    System.out.println("Done! Next command: ");
                    break;
                case 8:
                    System.out.println("Please type book's index to print it: ");
                    System.out.println(books.getByIndex(readIndex()));
                    System.out.println("Done! Next command: ");
                    break;
                case 9:
                    books.printBooks();
                    System.out.println("Done! Next command: ");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown code");
            }
        }
    }

    @Override
    public void startMenu() {
        startMenu(new ArrayList<>());
    }

    private Book readBook() {
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

    private int readCode() {
        return scanner.nextInt();
    }

    private int readIndex() {
        return scanner.nextInt();
    }

    private int readNumber() {
        return scanner.nextInt();
    }

    private String readAuthor() {
        return scanner.next();
    }

    private String readName() {
        return scanner.next();
    }

    private int readReleaseDate() {
        return scanner.nextInt();
    }
}
