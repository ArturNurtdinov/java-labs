package controllers;

import data.Bank;
import data.BankAccount;
import data.BankConcurrent;
import data.BankSynchronized;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Lab6Controller {
    @FXML
    Label notPerformed;
    @FXML
    TableView<BankAccount> outputTable;
    @FXML
    TableColumn<?, ?> nameCol;
    @FXML
    TableColumn<?, ?> balanceCol;
    @FXML
    TextField accounts;
    @FXML
    TextField fileName;
    @FXML
    RadioButton useConcurrent;
    @FXML
    RadioButton useSync;

    @FXML
    private void generateBank() {
        try {
            generateData(fileName.getText());
            nameCol.setCellValueFactory(new PropertyValueFactory<>("holderName"));
            balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
            outputTable.getItems().clear();

            if (useConcurrent.isSelected()) {
                Bank bank = new BankConcurrent(Integer.parseInt(accounts.getText()));
                bank.executeTransfersFromFile(fileName.getText());
                bank.getAccountMap().values().forEach((it) -> outputTable.getItems().add(it));
                notPerformed.setText("Not performed: " + bank.getNotPerformedOperations());
            } else {
                Bank bank = new BankSynchronized(Integer.parseInt(accounts.getText()));
                bank.executeTransfersFromFile(fileName.getText());
                bank.getAccountMap().values().forEach((it) -> outputTable.getItems().add(it));
                notPerformed.setText("Not performed: " + bank.getNotPerformedOperations());
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid index");
            alert.setHeaderText(null);
            alert.setContentText("Please type correct index");
            alert.showAndWait();
        }
    }


    // Copied private function from Main in 6th lab
    private void generateData(String fileName) throws FileNotFoundException {
        Random random = new Random();
        PrintWriter out = new PrintWriter(new FileOutputStream(fileName));

        for (int i = 0; i < 100; i++) {
            out.println("" + random.nextInt(Integer.parseInt(accounts.getText())) + ',' + random.nextInt(Integer.parseInt(accounts.getText())) + ',' + random.nextInt(1000));
        }

        out.close();
    }
}
