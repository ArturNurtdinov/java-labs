package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import custom.UndoStringBuilder;


public class Lab3Controller {
    @FXML
    TextField input;
    @FXML
    TextField index;
    @FXML
    Label output;


    UndoStringBuilder sb = new UndoStringBuilder();

    @FXML
    private void append() {
        sb.append(input.getText());
        output.setText(sb.toString());
    }

    @FXML
    private void deleteChar() {
        try {
            sb.deleteCharAt(Integer.parseInt(index.getText()));
            output.setText(sb.toString());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid index");
            alert.setHeaderText(null);
            alert.setContentText("Please type correct index");
            alert.showAndWait();
        }
    }

    @FXML
    private void reverse() {
        sb.reverse();
        output.setText(sb.toString());
    }

    @FXML
    private void clear() {
        sb = new UndoStringBuilder();
        output.setText(sb.toString());
    }

    @FXML
    private void undo() {
        try {
            sb.undo();
            output.setText(sb.toString());
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing changes");
            alert.setHeaderText(null);
            alert.setContentText("No changes to undo");
            alert.showAndWait();
        }
    }
}
