import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AccountTest {
    public static void main(String[] args) {
        // Create an executor service with a fixed thread pool of 2 threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        // Create an account with an initial balance of 10000
        Account account = new Account(10000);
        // Create an ArrayList to store the transactions
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        transactions.add(new Transaction(account, "deposit", 2000));
        transactions.add(new Transaction(account, "withdraw", 6000));
        transactions.add(new Transaction(account, "deposit", 3000));
        transactions.add(new Transaction(account, "withdraw", 1000));

        for (Transaction transaction: transactions){
            // Execute the transaction by submitting it to the executor
            executor.execute(transaction);
        }

        // Shutdown the executor service
        executor.shutdown();
    }
}
