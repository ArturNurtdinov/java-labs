package data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountConcurrent extends BankAccount {
    private Lock lock = new ReentrantLock();

    public BankAccountConcurrent(String holderName, int balance) {
        super(holderName, balance);
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void withdraw(int amount) {
        lock.lock();
        try {
            if (amount > balance) {
                throw new IllegalArgumentException("Cannot withdraw more than have");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
}
