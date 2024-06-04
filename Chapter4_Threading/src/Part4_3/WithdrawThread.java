package Part4_3;

class WithdrawThread implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(amount);
            try {
                Thread.sleep(100); // simulate time taken for withdrawal
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
