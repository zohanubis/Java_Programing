package Part4_3;

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread depositThread = new Thread(new DepositThread(account, 200), "DepositThread");
        Thread withdrawThread = new Thread(new WithdrawThread(account, 150), "WithdrawThread");

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
