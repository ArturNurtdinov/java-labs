import java.util.ArrayList;

public class Main {
    private static TaskContract.Task1 task1 = new Task1();
    private static TaskContract.Task2 task2 = new Task2();
    private static TaskContract.Task3 task3 = new Task3();

    public static void main(String[] args) {
        task1.printMatrix(task1.createMatrix(5, 10));
        System.out.println("--------------------------------");

        task2.printArray(task2.splitAndReplace("SplitMe"));
        System.out.println("--------------------------------");

        task3.printMenu();
        BookList books = new BookList();
        while (true) {
            int code = task3.readCode();
            switch (code) {
                case 1:
                    books.add(task3.readBook());
                    System.out.println("Done! Next command: ");
                    break;
                case 2:
                    System.out.println("Please type book's index to delete it: ");
                    books.delete(task3.readIndex());
                    System.out.println("Done! Next command: ");
                    break;
                case 3:
                    System.out.println("Please type book's number: ");
                    ArrayList<Book> byNumber = books.getByNumber(task3.readNumber());
                    printBookList(byNumber);
                    System.out.println("Done! Next command: ");
                    break;
                case 4:
                    System.out.println("Please type book's author: ");
                    ArrayList<Book> byAuthor = books.getByAuthor(task3.readAuthor());
                    printBookList(byAuthor);
                    System.out.println("Done! Next command: ");
                    break;
                case 5:
                    System.out.println("Please type book's name: ");
                    ArrayList<Book> byName = books.getByName(task3.readName());
                    printBookList(byName);
                    System.out.println("Done! Next command: ");
                    break;
                case 6:
                    System.out.println("Please type book's release date: ");
                    ArrayList<Book> byDate = books.getByReleaseDate(task3.readReleaseDate());
                    printBookList(byDate);
                    System.out.println("Done! Next command: ");
                    break;
                case 7:
                    System.out.println("Please type book's index to update it: ");
                    int indexToUpdate = task3.readIndex();
                    books.update(indexToUpdate, task3.readBook());
                    System.out.println("Done! Next command: ");
                    break;
                case 8:
                    System.out.println("Please type book's index to print it: ");
                    System.out.println(books.getByIndex(task3.readIndex()));
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

    private static void printBookList(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
