package data;

public class BankConcurrent extends Bank {
    public BankConcurrent(int size) {
        for (int i = 0; i < size; i++) {
            accountMap.put(String.valueOf(i), new BankAccountConcurrent("name" + i, 5000));
        }
        notPerformedOperations = 0;
    }

    @Override
    public void transfer(String fromId, String toId, int amount) {
        BankAccountConcurrent fromAccount = (BankAccountConcurrent) accountMap.get(fromId);
        BankAccountConcurrent toAccount = (BankAccountConcurrent) accountMap.get(toId);

        while (true) {
            boolean locked1 = fromAccount.getLock().tryLock();
            boolean locked2 = toAccount.getLock().tryLock();

            if (locked1 && locked2) {
                break;
            }

            if (locked1) {
                fromAccount.getLock().unlock();
            }

            if (locked2) {
                toAccount.getLock().unlock();
            }
        }

        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } finally {
            fromAccount.getLock().unlock();
            toAccount.getLock().unlock();
        }
    }
}
