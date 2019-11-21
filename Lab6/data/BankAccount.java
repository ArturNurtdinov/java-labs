package data;

public abstract class BankAccount {
    int balance;
    String holderName;

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

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);
}
