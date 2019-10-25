import animals.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Carnivore("Wolf"));
        list.add(new Herbivore("Chicken"));
        list.add(new Omnivore("Human"));
        list.add(new Herbivore("bark"));
        list.add(new Herbivore("Romashkoed", "ROMASHKA", 500));

        sortList(list);
        try {
            // First five elements of sorted list
            acceptOnRange(list, 0, 5, System.out::println);
            // Last three uid of sorted list
            acceptOnRange(list, list.size() - 3, list.size(), animal -> System.out.println(animal.getUid()));

            //writing to file
            writeToFile(list, "animals.tmp");

            //reading from file and printing result
            ArrayList<Animal> readList = new ArrayList<>(readFromFile("animals.tmp"));
            acceptOnRange(readList, 0, readList.size(), System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void sortList(List<Animal> list) {
        list.sort((o1, o2) -> {
            if (o1.getFood().getAmount() != o2.getFood().getAmount()) {
                return o1.getFood().getAmount() - o2.getFood().getAmount();
            }
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        });
    }

    private static void acceptOnRange(List<Animal> list, int rangeFrom, int rangeTo,
                                      Consumer<Animal> consumer) {
        if ((rangeFrom < 0) || (rangeTo > list.size())) {
            throw new IndexOutOfBoundsException("Range is out of bounds");
        }

        if (rangeFrom > rangeTo) {
            throw new IndexOutOfBoundsException("Invalid range");
        }

        for (int i = rangeFrom; i < rangeTo; i++) {
            consumer.accept(list.get(i));
        }
    }

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
