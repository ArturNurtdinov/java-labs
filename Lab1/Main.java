import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(5, 10);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        String s = new String("dasdasdsadsadsadsadsadsadsadasdsa");
        String[] res = splitByThree(s);
        for (String r : res) {
            System.out.println(r);
        }
        System.out.println("--------------------------------");
        System.out.println("Type 1 to add book");
        System.out.println("Type 2 to delete book by index");
        System.out.println("Type 3 to find books by number");
        System.out.println("Type 4 to find books by author");
        System.out.println("Type 5 to find books by name");
        System.out.println("Type 6 to find books by releaseDate");
        System.out.println("Type 7 to update book");
        System.out.println("Type 8 to read book by index");
        System.out.println("Type 9 to print all books");
        BookList books = new BookList();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while (true) {
            int code = scanner.nextInt();
            switch (code) {
                case 1:
                    System.out.println("Please insert a book to add:");
                    System.out.print("Number = ");
                    int number = scanner.nextInt();
                    System.out.print("Author = ");
                    String author = scanner.next();
                    System.out.print("Name = ");
                    String name = scanner.next();
                    System.out.print("Release date = ");
                    int releaseDate = scanner.nextInt();
                    books.add(new Book(number, author, name, releaseDate));
                    System.out.println("Done! Next command: ");
                    break;
                case 2:
                    System.out.println("Please type book's index: ");
                    int index = scanner.nextInt();
                    books.delete(index);
                    System.out.println("Done! Next command: ");
                    break;
                case 3:
                    System.out.println("Please type book's number: ");
                    int numberToFind = scanner.nextInt();
                    ArrayList<Book> byNumber = books.getByNumber(numberToFind);
                    for (Book book : byNumber) {
                        System.out.println(book);
                    }
                    System.out.println("Done! Next command: ");
                    break;
                case 4:
                    System.out.println("Please type book's author: ");
                    String authorToFind = scanner.next();
                    ArrayList<Book> byAuthor = books.getByAuthor(authorToFind);
                    for (Book book : byAuthor) {
                        System.out.println(book);
                    }
                    System.out.println("Done! Next command: ");
                    break;
                case 5:
                    System.out.println("Please type book's name: ");
                    String nameToFind = scanner.next();
                    ArrayList<Book> byName = books.getByName(nameToFind);
                    for (Book book : byName) {
                        System.out.println(book);
                    }
                    System.out.println("Done! Next command: ");
                    break;
                case 6:
                    System.out.println("Please type book's release date: ");
                    int releaseDateToFind = scanner.nextInt();
                    ArrayList<Book> byDate = books.getByReleaseDate(releaseDateToFind);
                    for (Book book : byDate) {
                        System.out.println(book);
                    }
                    System.out.println("Done! Next command: ");
                    break;
                case 7:
                    System.out.println("Please type book's index to update it: ");
                    int indexToUpdate = scanner.nextInt();
                    System.out.println("Please insert a new book: ");
                    System.out.print("Number = ");
                    int newNumber = scanner.nextInt();
                    System.out.print("Author = ");
                    String newAuthor = scanner.next();
                    System.out.print("Name = ");
                    String newName = scanner.next();
                    System.out.print("Release date = ");
                    int newReleaseDate = scanner.nextInt();
                    books.update(indexToUpdate, new Book(newNumber, newAuthor, newName, newReleaseDate));
                    System.out.println("Done! Next command: ");
                    break;
                case 8:
                    System.out.println("Please type book's index to print it: ");
                    int indexToPrint = scanner.nextInt();
                    System.out.println(books.getByIndex(indexToPrint));
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

    private static int[][] createMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                matrix[i][j] = 0;
            }
            matrix[i][0] = 1;
        }
        return matrix;
    }

    private static String[] splitByThree(String s) {
        String[] res = new String[s.length() / 3];
        for (int i = 0; i < s.length() / 3; ++i) {
            char symbol = getRandomChar();
            while ((symbol == s.charAt(i * 3)) || (symbol == s.charAt(i * 3 + 2))) {
                symbol = getRandomChar();
            }
            String temp = "" + s.charAt(i * 3) + symbol + s.charAt(i * 3 + 2);
            res[i] = temp;

        }
        return res;
    }

    private static char getRandomChar() {
        SecureRandom random = new SecureRandom();
        return (char) random.nextInt(127);
    }
}
