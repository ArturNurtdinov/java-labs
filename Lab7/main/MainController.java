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
    private Button lab3Button;
    @FXML
    private Button lab4Button;
    @FXML
    private Button lab5Button;
    @FXML
    private Button lab6Button;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() == lab1Button) {
            createStage("Lab1", "lab1.fxml");
        } else if (event.getSource() == lab2Button) {
            createStage("Lab2", "lab2.fxml");
        } else if (event.getSource() == lab3Button) {
            createStage("Lab3", "lab3.fxml");
        } else if (event.getSource() == lab4Button) {
            createStage("Lab4", "lab4.fxml");
        } else if (event.getSource() == lab5Button) {
            createStage("Lab5", "lab5.fxml");
        } else if (event.getSource() == lab6Button) {
            createStage("Lab6", "lab6.fxml");
        }
    }

    private void createStage(String title, String source) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(source));
            stage.setTitle(title);
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
