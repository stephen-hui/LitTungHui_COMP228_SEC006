public class Transaction implements Runnable {
    private Account account;
    private String transactionType;
    private int amount;

    public Transaction(Account account, String transactionType, int amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        // check if deposit or withdraw
        if (this.transactionType.equalsIgnoreCase("deposit")) {
            this.account.deposit(amount);
        } else if (this.transactionType.equalsIgnoreCase("withdraw")) {
            this.account.withdraw(amount);
        } else{
            System.out.println("Invalid transaction type");
        }
    }
}
