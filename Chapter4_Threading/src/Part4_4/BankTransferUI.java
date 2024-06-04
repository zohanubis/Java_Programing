package Part4_4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankTransferUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private BankAccount accountFrom;
    private BankAccount accountTo;
    private TransferThread transferThread;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BankTransferUI frame = new BankTransferUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BankTransferUI() {
        setTitle("Bank Transfer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        // Sử dụng BorderLayout để tự động điều chỉnh kích thước
        getContentPane().setLayout(new BorderLayout());

        // Tạo JPanel cho các nút bấm và đặt ở phía dưới của BorderLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnStart = new JButton("Start");
        buttonPanel.add(btnStart);

        JButton btnStop = new JButton("Stop");
        buttonPanel.add(btnStop);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Tạo JScrollPane cho JTable và đặt ở giữa của BorderLayout
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Thread Name", "Số tiền chuyển", "Chuyển từ tài khoản", "Chuyển tới tài khoản", "Tổng tiền thực hiện"}
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        accountFrom = new BankAccount();
        accountTo = new BankAccount();

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTransfer();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTransfer();
            }
        });
    }

    protected void startTransfer() {
        transferThread = new TransferThread(accountFrom, accountTo, tableModel);
        transferThread.start();
    }

    protected void stopTransfer() {
        if (transferThread != null) {
            transferThread.interrupt();
        }
    }
}