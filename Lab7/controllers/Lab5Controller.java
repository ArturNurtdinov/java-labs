package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.PropertiesExplorer;

import java.util.Map;

public class Lab5Controller {
    @FXML
    TextField fileName;
    @FXML
    Label output;

    @FXML
    private void readProperties() {
        try {
            output.setText(mapToString(new PropertiesExplorer(fileName.getText()).getContent()));
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    private String mapToString(Map<String, String> map) {
        StringBuilder res = new StringBuilder();
        map.forEach((s, s2) -> {
            res.append(s);
            res.append("=");
            res.append(s2);
            res.append('\n');
        });
        return res.toString();
    }
}
