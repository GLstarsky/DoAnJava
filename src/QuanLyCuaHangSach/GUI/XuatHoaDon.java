package QuanLyCuaHangSach.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import com.itextpdf.text.pdf.PdfWriter;


public class XuatHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			XuatHoaDon dialog = new XuatHoaDon();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public XuatHoaDon() {
		setBounds(100, 100, 405, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(211, 211, 211));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 397, 147);
		panel.setBackground(new Color(220, 220, 220));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thanh toán thành công !");
		lblNewLabel.setBounds(66, 10, 291, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));

		JButton btnXuatPDF = new JButton("Xuất hóa đơn ");
		btnXuatPDF.setBackground(new Color(95, 158, 160));
		btnXuatPDF.setBounds(66, 54, 142, 35);
		panel.add(btnXuatPDF);
		btnXuatPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuatPDF.setFont(new Font("Palatino Linotype", Font.BOLD, 15));

		JButton btnTatThongBao = new JButton("Đóng");
		btnTatThongBao.setBounds(215, 54, 89, 35);
		panel.add(btnTatThongBao);
		btnTatThongBao.setFont(new Font("Palatino Linotype", Font.BOLD, 15));

		JLabel lblXuatPdfThanhCong = new JLabel("");
		lblXuatPdfThanhCong.setForeground(new Color(47, 79, 79));
		lblXuatPdfThanhCong.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblXuatPdfThanhCong.setBounds(76, 99, 305, 38);
		panel.add(lblXuatPdfThanhCong);

		btnXuatPDF.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream("hoadon_" + HienThiKhuyenMaiGUI.maPhieuXuatHienTai + ".pdf"));
					document.open();
					document.add(new Paragraph("\nKhách hàng: (" + ChonKhachHangNhanVien.maKhachHang + ") "
							+ ChonKhachHangNhanVien.tenKhachHang));
					document.add(new Paragraph("\nNhân viên xuất đơn: (" + ChonKhachHangNhanVien.maNhanVien + ") "
							+ ChonKhachHangNhanVien.tenNhanVien));
					for (int i = 0; i < BanHangGUI.gioHang.size(); i++) {
						int maSach = BanHangGUI.gioHang.get(i).getMaSach();
						String tenSach = BanHangGUI.gioHang.get(i).getTenSach();
						int donGia = BanHangGUI.gioHang.get(i).getDonGia();
						int soLuong = BanHangGUI.gioHang.get(i).getSoLuong();
						int tongLoai = BanHangGUI.gioHang.get(i).getTongTien();
						document.add(new Paragraph("\nSách: (" + maSach + ") " + tenSach ));
						document.add(new Paragraph("\nĐơn giá: " + tenSach));
						document.add(new Paragraph("\nSố lượng: " + soLuong));
						document.add(new Paragraph("\nTổng loại: " + tongLoai));
					}
					document.add(new Paragraph("\nTổng cộng: " + HienThiKhuyenMaiGUI.tongThanhToan));
					java.util.Date ngayXuat = new java.util.Date();
					document.add(new Paragraph("\nNgày xuất hóa đơn: " + ngayXuat));
					document.close();
				} catch (DocumentException | FileNotFoundException ex) {
					((Throwable) ex).printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				lblXuatPdfThanhCong.setText("Xuất hóa đơn pdf thành công !");
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		btnTatThongBao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XuatHoaDon.this.setVisible(false);
				TrangChuGUI trangBanHangMoi = new TrangChuGUI();
				trangBanHangMoi.setVisible(true);
			}
		});

	}
}