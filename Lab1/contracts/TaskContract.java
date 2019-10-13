package contracts;

import data.Book;

import java.util.ArrayList;

public interface TaskContract {
    interface Task1{
        int[][] createMatrix(int n, int m);
        void printMatrix(int[][] matrix);
    }

    interface Task2{
        String[] splitAndReplace(String s);
        void printArray(String[] strings);
    }

    interface Task3{
        void startMenu() throws IllegalArgumentException;
    }
}
