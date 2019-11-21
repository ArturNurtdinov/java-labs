package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class Bank {
    Map<String, BankAccount> accountMap = new HashMap<>();
    int notPerformedOperations;

    public Map<String, BankAccount> getAccountMap() {
        return accountMap;
    }

    public int getNotPerformedOperations() {
        return notPerformedOperations;
    }

    public void executeTransfersFromFile(String fileName) throws FileNotFoundException, InterruptedException {
        Scanner in = new Scanner(new FileInputStream(fileName));
        ExecutorService executor = Executors.newCachedThreadPool();

        while (in.hasNextLine()) {
            String[] transfer = in.nextLine().split(",");
            executor.submit(() -> transfer(transfer[0], transfer[1], Integer.parseInt(transfer[2])));
        }

        executor.shutdown();
        executor.awaitTermination(12, TimeUnit.HOURS);
    }

    public abstract void transfer(String fromId, String toId, int amount);
}
