package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Bank {
    Map<String, BankAccount> accountMap = new HashMap<>();
    private int invalidOperations;

    public Bank(int size) {
        for (int i = 0; i < size; i++) {
            accountMap.put(String.valueOf(i), new BankAccount("name" + i, 5000));
        }
        invalidOperations = 0;
    }

    public Map<String, BankAccount> getAccountMap() {
        return accountMap;
    }

    public int getInvalidOperations() {
        return invalidOperations;
    }

    public void transfer(String fromId, String toId, int amount) {
        BankAccount fromAcc = accountMap.get(fromId);
        BankAccount toAcc = accountMap.get(toId);

        acquireLocks(fromAcc.getLock(), toAcc.getLock());
        try {
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);
        } catch (IllegalArgumentException ex) {
            invalidOperations++;
        } finally {
            fromAcc.getLock().unlock();
            toAcc.getLock().unlock();
        }
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

    private void acquireLocks(Lock lock1, Lock lock2) {
        while (true) {
            boolean isFirstLocked = lock1.tryLock();
            boolean isSecondLocked = lock2.tryLock();

            if (isFirstLocked && isSecondLocked) {
                break;
            }

            if (isFirstLocked) {
                lock1.unlock();
            }

            if (isSecondLocked) {
                lock2.unlock();
            }
        }
    }
}
