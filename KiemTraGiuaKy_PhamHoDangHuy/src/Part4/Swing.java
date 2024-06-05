package Part4;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//Bài 4
public class Swing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaNhanVien;
    private JTextField txtLuongCoBan;
    private JTextField txtLuongThang;
    private JTextField txtTroCap;
    private JTextField txtSoNgayLamviec;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Swing frame = new Swing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Swing() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 601, 459);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblA = new JLabel("Mã Nhân Viên");
        lblA.setFont(new Font("Arial", Font.BOLD, 16));
        lblA.setBounds(39, 71, 121, 49);
        contentPane.add(lblA);

        JLabel lblB = new JLabel("Lương Cơ Bản");
        lblB.setFont(new Font("Arial", Font.BOLD, 16));
        lblB.setBounds(34, 123, 126, 49);
        contentPane.add(lblB);

        txtMaNhanVien = new JTextField();
        txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
        txtMaNhanVien.setBounds(195, 87, 105, 20);
        contentPane.add(txtMaNhanVien);
        txtMaNhanVien.setColumns(10);

        txtLuongCoBan = new JTextField();
        txtLuongCoBan.setFont(new Font("Arial", Font.PLAIN, 16));
        txtLuongCoBan.setColumns(10);
        txtLuongCoBan.setBounds(195, 137, 105, 20);
        contentPane.add(txtLuongCoBan);

        JLabel lblTrCp = new JLabel("Trợ Cấp");
        lblTrCp.setFont(new Font("Arial", Font.BOLD, 16));
        lblTrCp.setBounds(315, 71, 121, 49);
        contentPane.add(lblTrCp);

        JLabel lblLngthng = new JLabel("Lương/Tháng");
        lblLngthng.setFont(new Font("Arial", Font.BOLD, 16));
        lblLngthng.setBounds(325, 123, 126, 49);
        contentPane.add(lblLngthng);

        txtLuongThang = new JTextField();
        txtLuongThang.setEditable(false); // Không cho phép chỉnh sửa
        txtLuongThang.setFont(new Font("Arial", Font.PLAIN, 16));
        txtLuongThang.setColumns(10);
        txtLuongThang.setBounds(471, 137, 105, 20);
        contentPane.add(txtLuongThang);

        txtTroCap = new JTextField();
        txtTroCap.setFont(new Font("Arial", Font.PLAIN, 16));
        txtTroCap.setColumns(10);
        txtTroCap.setBounds(471, 87, 105, 20);
        contentPane.add(txtTroCap);

        JLabel lblSNgyLm = new JLabel("Số Ngày Làm Việc");
        lblSNgyLm.setFont(new Font("Arial", Font.BOLD, 16));
        lblSNgyLm.setBounds(34, 177, 151, 49);
        contentPane.add(lblSNgyLm);

        txtSoNgayLamviec = new JTextField();
        txtSoNgayLamviec.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSoNgayLamviec.setColumns(10);
        txtSoNgayLamviec.setBounds(195, 191, 105, 20);
        contentPane.add(txtSoNgayLamviec);

        JButton btnTinhLuong = new JButton("Tính Lương");
        btnTinhLuong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các JTextField
                double luongCB = Double.parseDouble(txtLuongCoBan.getText());
                double troCap = Double.parseDouble(txtTroCap.getText());
                int soNgayLamViec = Integer.parseInt(txtSoNgayLamviec.getText());

                // Tính lương
                double luong = luongCB + soNgayLamViec * 100000 + troCap;

                // Hiển thị kết quả vào JTextField "Lương/tháng"
                txtLuongThang.setText(String.valueOf(luong));
            }
        });
        btnTinhLuong.setBounds(60, 386, 89, 23);
        contentPane.add(btnTinhLuong);

        JButton btnThemMoi = new JButton("Thêm Mới");
        btnThemMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xóa các giá trị trong các JTextField
                txtMaNhanVien.setText("");
                txtLuongCoBan.setText("");
                txtSoNgayLamviec.setText("");
                txtTroCap.setText("");
                txtLuongThang.setText("");

                // Đưa con trỏ chuột về ô nhập mã nhân viên
                txtMaNhanVien.requestFocus();
            }
        });
        btnThemMoi.setBounds(247, 386, 89, 23);
        contentPane.add(btnThemMoi);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các JTextField
                String maNV = txtMaNhanVien.getText();
                double luongCB = Double.parseDouble(txtLuongCoBan.getText());
                double troCap = Double.parseDouble(txtTroCap.getText());
                int soNgayLamViec = Integer.parseInt(txtSoNgayLamviec.getText());
                double luongThang = Double.parseDouble(txtLuongThang.getText());

                // Thêm thông tin nhân viên vào table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{maNV, luongCB, soNgayLamViec, troCap, luongThang});
            }
        });
        btnLuu.setBounds(431, 386, 89, 23);
        contentPane.add(btnLuu);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 224, 522, 129);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"MaNV", "LCB", "NgayLamViec", "TroCap", "Luong"}
        ));
        scrollPane.setViewportView(table);
    }
}
