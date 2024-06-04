package Part4_3;

class DepositThread implements Runnable {
    private BankAccount account;
    private int amount;

    public DepositThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    //Mỗi lần chạy sẽ gửi một số tiền 
    //nhất định vào tài khoản 5 lần, mỗi lần cách nhau 100 milliseconds.
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(amount);
            try {
                Thread.sleep(100); // simulate time taken for deposit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
