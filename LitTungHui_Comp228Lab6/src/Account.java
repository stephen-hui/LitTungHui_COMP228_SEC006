public class Account {
    private int balance;

    // constructor
    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        // make sure amount is positive
        if (amount > 0){
            this.balance += amount;
            System.out.println("Successfully deposited " + amount + "\nThe new balance is " + this.balance);
        }
        else {
            System.out.println("You can't deposit negative amount");
        }
    }

    public synchronized void withdraw(int amount) {
        // check amount is positive and have enough balance
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Successfully withdrawn " + amount + "\nThe new balance is " + this.balance);
        } else {
            System.out.println("Insufficient balance or negative amount");
        }
    }
}
