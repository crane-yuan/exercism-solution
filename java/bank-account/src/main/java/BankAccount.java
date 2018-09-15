public class BankAccount {

    int balance;
    boolean isOpen;

    public void open() {
        this.balance = 0;
        this.isOpen = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        assertOpened();
        return balance;
    }

    public synchronized void deposit(int money) throws BankAccountActionInvalidException {
        assertOpened();
        assertMoney(money);

        this.balance += money;
    }

    public synchronized void withdraw(int money) throws BankAccountActionInvalidException {
        assertOpened();
        assertMoney(money);

        if (this.balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if (this.balance < money) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        this.balance -= money;
    }

    public void close() throws BankAccountActionInvalidException {
//        assertOpened();
        this.isOpen = false;
    }

    private void assertOpened() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    private void assertMoney(int money) throws BankAccountActionInvalidException {
        if (money < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

}
