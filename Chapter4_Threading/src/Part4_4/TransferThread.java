package Part4_4;

import javax.swing.table.DefaultTableModel;

public class TransferThread extends Thread {
    private BankAccount from;
    private BankAccount to;
    private DefaultTableModel model;

    public TransferThread(BankAccount from, BankAccount to, DefaultTableModel model) {
        this.from = from;
        this.to = to;
        this.model = model;
    }

    @Override
    public void run() {
        int amount = 100;
        while (!isInterrupted()) {
            from.withdraw(amount);
            to.deposit(amount);
            model.addRow(new Object[]{Thread.currentThread().getName(), amount, from.getBalance(), to.getBalance(), amount});
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}