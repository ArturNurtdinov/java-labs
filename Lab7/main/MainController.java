package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {
    @FXML
    private Button lab1Button;
    @FXML
    private Button lab2Button;
    @FXML
    private Button lab4Button;
    @FXML
    private Button lab5Button;
    @FXML
    private Button lab6Button;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() == lab1Button) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("lab1.fxml"));
                stage.setTitle("Lab1");
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } else if (event.getSource() == lab2Button) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("lab2.fxml"));
                stage.setTitle("Lab2");
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } else if (event.getSource() == lab4Button) {
            System.out.println("Lab 4");
        } else if (event.getSource() == lab5Button) {
            System.out.println("Lab 5");
        } else if (event.getSource() == lab6Button) {
            System.out.println("Lab 6");
        }
    }
}
