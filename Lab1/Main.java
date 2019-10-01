import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskContract.Task1 task1 = new Task1();
        task1.printMatrix(task1.createMatrix(5, 10));
        System.out.println("--------------------------------");

        TaskContract.Task2 task2 = new Task2();
        task2.printArray(task2.splitAndReplace("SplitMe"));
        System.out.println("--------------------------------");

        TaskContract.Task3 task3 = new Task3();
        task3.startMenu();
    }
}
