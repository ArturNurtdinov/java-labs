package controllers;

import animals.Animal;
import animals.Carnivore;
import animals.Herbivore;
import animals.Omnivore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lab2Controller {
    @FXML
    Label animalsLabel;

    @FXML
    TextField animalId;
    @FXML
    TextField type;
    @FXML
    TextField name;
    @FXML
    TextField foodType;
    @FXML
    TextField foodAmount;
    @FXML
    TextField fileName;

    private ArrayList<Animal> animals = new ArrayList<>();

    @FXML
    private void addAnimal() {
        switch (type.getText().toLowerCase()) {
            case "carnivore":
                animals.add(new Carnivore(name.getText(), animalId.getText(), foodType.getText(), Integer.parseInt(foodAmount.getText())));
                break;
            case "herbivore":
                animals.add(new Herbivore(name.getText(), animalId.getText(), foodType.getText(), Integer.parseInt(foodAmount.getText())));
                break;
            case "omnivore":
                animals.add(new Omnivore(name.getText(), animalId.getText(), foodType.getText(), Integer.parseInt(foodAmount.getText())));
                break;
        }

        printList();
    }

    @FXML
    private void clearList() {
        animals.clear();
        animalsLabel.setText("");
    }

    @FXML
    private void sortList() {
        animals.sort((o1, o2) -> o1.getFood().getAmount() != o2.getFood().getAmount() ?
                o1.getFood().getAmount() - o2.getFood().getAmount() :
                o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()));
        printList();
    }

    @FXML
    private void loadFromFile() {
        try {
            animals = new ArrayList<>(readFromFile(fileName.getText()));
        } catch (Exception ex) {
            animalsLabel.setText(ex.getMessage());
        }
        printList();
    }

    @FXML
    private void printToFile() {
        try {
           writeToFile(animals, fileName.getText());
        } catch (IOException ex) {
            animalsLabel.setText(ex.getMessage());
        }
    }

    private void printList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < animals.size(); i++) {
            sb.append(animals.get(i).toString());
            sb.append('\n');
        }

        animalsLabel.setText(sb.toString());
    }

    // I copied these functions from Lab2, because they were in Main class and I couldn't use it here.
    private static void writeToFile(List<Animal> list, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(list);
        oos.close();
    }

    private static List<Animal> readFromFile(String filename) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        List<Animal> list = (List<Animal>) ois.readObject();
        ois.close();
        return list;
    }
}
