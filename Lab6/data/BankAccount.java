package data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private String holderName;
    private Lock lock = new ReentrantLock();

    public BankAccount(String holderName, int balance) {
        this.balance = balance;
        this.holderName = holderName;
    }

    public int getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public Lock getLock() {
        return lock;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (amount > balance) {
                throw new IllegalArgumentException("It's not allowed to deposit more than balance has");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
}
