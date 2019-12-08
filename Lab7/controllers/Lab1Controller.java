package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tasks.Task1;
import tasks.Task2;
import tasks.Task3;


public class Lab1Controller {
    @FXML
    Label labelForMatrix;
    @FXML
    Label labelForString;
    @FXML
    TextField string;

    @FXML
    private void createMatrix() {
        Task1 task1 = new Task1();
        labelForMatrix.setText("Your matrix: \n" + matrixToString(task1.createMatrix(10, 10)));
    }

    @FXML
    private void splitString() {
        Task2 task2 = new Task2();
        labelForString.setText(arrayToString(task2.splitAndReplace(string.getText())));
    }

    @FXML
    private void startMenu() {
        new Task3().startMenu();
    }

    private String arrayToString(String[] array) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            res.append(array[i]);
            res.append(' ');
        }
        return res.toString();
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res.append(matrix[i][j]);
                res.append(' ');
            }
            res.append('\n');
        }
        return res.toString();
    }
}
