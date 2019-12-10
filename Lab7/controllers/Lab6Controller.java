package controllers;

import data.Bank;
import data.BankConcurrent;
import data.BankSynchronized;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Lab6Controller {
    @FXML
    Label output;
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

            if (useConcurrent.isSelected()) {
                Bank bank = new BankConcurrent(Integer.parseInt(accounts.getText()));
                bank.executeTransfersFromFile(fileName.getText());
                StringBuilder sb = new StringBuilder();
                bank.getAccountMap().forEach((key, value) -> {
                    sb.append(key);
                    sb.append(": ");
                    sb.append(value.getHolderName());
                    sb.append(" ");
                    sb.append(value.getBalance());
                    sb.append('\n');
                });
                sb.append("Not perfomed: ");
                sb.append(bank.getNotPerformedOperations());

                output.setText(sb.toString());
            } else {
                Bank bank = new BankSynchronized(Integer.parseInt(accounts.getText()));
                bank.executeTransfersFromFile(fileName.getText());
                StringBuilder sb = new StringBuilder();
                bank.getAccountMap().forEach((key, value) -> {
                    sb.append(key);
                    sb.append(": ");
                    sb.append(value.getHolderName());
                    sb.append(" ");
                    sb.append(value.getBalance());
                    sb.append('\n');
                });
                sb.append("Not perfomed: ");
                sb.append(bank.getNotPerformedOperations());

                output.setText(sb.toString());
            }

        } catch (Exception ex) {
            output.setText(ex.getMessage());
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
