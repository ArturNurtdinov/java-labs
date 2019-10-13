import contracts.TaskContract;
import tasks.Task1;
import tasks.Task2;
import tasks.Task3;

public class Main {
    public static void main(String[] args) {
        TaskContract.Task1 task1 = new Task1();
        task1.printMatrix(task1.createMatrix(5, 10));
        System.out.println("--------------------------------");

        TaskContract.Task2 task2 = new Task2();
        task2.printArray(task2.splitAndReplace("SplitMe"));
        System.out.println("--------------------------------");

        TaskContract.Task3 task3 = new Task3();
        try {
            task3.startMenu();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
