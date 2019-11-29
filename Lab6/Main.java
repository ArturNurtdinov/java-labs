import data.Bank;
import data.BankConcurrent;
import data.BankSynchronized;

import java.io.*;
import java.util.Random;

public class Main {
    private static final int BANK_SIZE = 10;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Missing argument.");
            System.out.println("Please pass 1 parameters which match input file");
            return;
        }

        try {
            System.out.println("With concurrent : ");
            generateData(args[0]);
            Bank bankConcurrent = new BankConcurrent(BANK_SIZE);
            bankConcurrent.executeTransfersFromFile(args[0]);
            System.out.println("Bank info :");
            bankConcurrent.getAccountMap().forEach((key, value) -> System.out.println(key + ": " + value.getHolderName() + " " + value.getBalance()));
            System.out.println("Not performed : " + bankConcurrent.getNotPerformedOperations());

            System.out.println("With synchronized : ");
            Bank bankSync = new BankSynchronized(BANK_SIZE);
            bankSync.executeTransfersFromFile(args[0]);
            System.out.println("Bank info :");
            bankSync.getAccountMap().forEach((key, value) -> System.out.println(key + ": " + value.getHolderName() + " " + value.getBalance()));
            System.out.println("Not performed : " + bankSync.getNotPerformedOperations());
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open file : " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void generateData(String fileName) throws FileNotFoundException {
        Random random = new Random();
        PrintWriter out = new PrintWriter(new FileOutputStream(fileName));

        for (int i = 0; i < 100; i++) {
            out.println("" + random.nextInt(BANK_SIZE) + ',' + random.nextInt(BANK_SIZE) + ',' + random.nextInt(1000));
        }

        out.close();
    }
}
