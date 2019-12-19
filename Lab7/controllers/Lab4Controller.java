package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import explorers.FileExplorer;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.OutputStream;
import java.io.PrintStream;

public class Lab4Controller {
    FileExplorer fileExplorer;

    @FXML
    private TextArea console;

    @FXML
    private TextField inputField;

    @FXML
    private void initialize() {
        PrintStream out = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                Platform.runLater(() -> {
                    console.appendText(String.valueOf((char) b));
                });
            }
        }, true);

        console.textProperty().addListener((observableValue, s, t1) -> console.setScrollTop(0));

        fileExplorer = new FileExplorer(System.in, out);
        fileExplorer.execute("");

        Platform.runLater(() -> inputField.requestFocus());
    }

    @FXML
    private void handleSubmit() {
        console.appendText(inputField.getText() + "\n");
        try {
            fileExplorer.execute(inputField.getText());
        } catch (Exception ex) {
            console.appendText(ex.getLocalizedMessage() + "\n");
        }
        inputField.setText("");
    }
}
