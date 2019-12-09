package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import util.FileExplorer;

public class Lab4Controller {
    @FXML
    private void start() {
        try {
            new FileExplorer().start();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}
