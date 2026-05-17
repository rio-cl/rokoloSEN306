package week10;

// Given class (DO NOT MODIFY)
class BankAccount {

    protected double balance = 0.0;

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Subclass
class OverdraftAccount extends BankAccount {

    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

    }

    @Override
    public void withdraw(double amount) {

        // Allows overdraft up to -500
        if (amount > 0 && (balance - amount) >= -500) {

            balance -= amount;
            System.out.println("Withdrawn: " + amount);

        } else {

            System.out.println("Withdrawal denied. Overdraft limit exceeded.");

        }
    }
}

// Main class for testing
public class exercise2 {

    public static void main(String[] args) {

        OverdraftAccount account = new OverdraftAccount();

        account.deposit(1000);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(1200);
        System.out.println("Balance: " + account.getBalance());

        account.withdraw(400);
        System.out.println("Balance: " + account.getBalance());

    }
}