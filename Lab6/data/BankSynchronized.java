package data;

public class BankSynchronized extends Bank {
    public BankSynchronized(int size) {
        for (int i = 0; i < size; i++) {
            accountMap.put(String.valueOf(i), new BankAccountSynchronized("name" + i, 5000));
        }
        notPerformedOperations = 0;
    }

    @Override
    public void transfer(String fromId, String toId, int amount) {
        BankAccount fromAcc = accountMap.get(fromId);
        BankAccount toAcc = accountMap.get(toId);

        BankAccount firstLock, secondLock;
        if (fromId.compareTo(toId) < 0) {
            firstLock = fromAcc;
            secondLock = toAcc;
        } else {
            firstLock = toAcc;
            secondLock = fromAcc;
        }

        synchronized (firstLock) {
            synchronized (secondLock) {
                fromAcc.withdraw(amount);
                toAcc.deposit(amount);
            }
        }
    }
}
