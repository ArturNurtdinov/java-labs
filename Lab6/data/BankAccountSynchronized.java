package data;

public class BankAccountSynchronized extends BankAccount {
    public BankAccountSynchronized(String holderName, int balance) {
        super(holderName, balance);
    }

    @Override
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    @Override
    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Cannot withdraw more than have");
        }
        balance -= amount;
    }
}
