package QuanLyCuaHangSachGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import QuanLyCuaHangSachBUS.ChiTietPhieuXuatBUS;
import QuanLyCuaHangSachBUS.ChuongTrinhKhuyenMai2BUS;
import QuanLyCuaHangSachBUS.KhuyenMaiTheoSachBUS;
import QuanLyCuaHangSachBUS.KhuyenMaiTheoTongTienBUS;
import QuanLyCuaHangSachBUS.PhieuXuatBUS;
import QuanLyCuaHangSachBUS.Sach2BUS;
import QuanLyCuaHangSachDTO.ChiTietPhieuXuatDTO;
import QuanLyCuaHangSachDTO.KhuyenMaiTheoSachDTO;
import QuanLyCuaHangSachDTO.KhuyenMaiTheoTongTienDTO;
import QuanLyCuaHangSachDTO.PhieuXuatDTO;
import QuanLyCuaHangSachGUI.BanHangGUI.chiTietGioHang;

public class HienThiKhuyenMaiGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblListKhuyenMai;
	public static int tongThanhToan = 0;
	public static JButton btnThanhToan;
	public static int maPhieuXuatHienTai;
	public static String thongBao = "";

	public class NonEditableTableModel extends DefaultTableModel {
		public NonEditableTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	private String formatGiaTien(int giaTien) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###.##₫");
		return decimalFormat.format(giaTien);
	}

	private void docListKhuyenMai(JTable table, ArrayList<chiTietGioHang> gioHang, int tongHoaDonBanDau) {
		KhuyenMaiTheoSachBUS kmTheoSachBUS = new KhuyenMaiTheoSachBUS();
		ArrayList<KhuyenMaiTheoSachDTO> dsKmTheoSach = kmTheoSachBUS.getListKhuyenMaiTheoSach();
		if (dsKmTheoSach == null || dsKmTheoSach.isEmpty()) {
			kmTheoSachBUS.docKhuyenMaiTheoSach();
			dsKmTheoSach = kmTheoSachBUS.getListKhuyenMaiTheoSach();
		}

		KhuyenMaiTheoTongTienBUS kmTheoTongTienBUS = new KhuyenMaiTheoTongTienBUS();
		ArrayList<KhuyenMaiTheoTongTienDTO> dsKmTheoTongTien = kmTheoTongTienBUS.getListKhuyenMaiTheoTongTien();
		if (dsKmTheoTongTien == null || dsKmTheoTongTien.isEmpty()) {
			kmTheoTongTienBUS.docKhuyenMaiTheoTongTien();
			dsKmTheoTongTien = kmTheoTongTienBUS.getListKhuyenMaiTheoTongTien();
		}
		Object[][] rowData = new Object[dsKmTheoSach.size() + dsKmTheoTongTien.size()][7];
		Object[] columnNames = { "Mã giảm giá", "Ưu đãi", "Giảm", "Từ ngày", "Đến ngày", "Mã sách áp dụng",
				"Hóa đơn từ" };

		Timestamp ngayTaoHoaDon = new java.sql.Timestamp(new java.util.Date().getTime());

		int hangKhuyenMai = 0;
		for (int i = 0; i < dsKmTheoSach.size(); i++) {
			KhuyenMaiTheoSachDTO kmtheosach = dsKmTheoSach.get(i);
			String tenCT = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheosach.getMaChuongTrinh()).getTen();
			Date ngayBD = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheosach.getMaChuongTrinh()).getNgayBD();
			Date ngayKT = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheosach.getMaChuongTrinh()).getNgayKT();

			for(int j=0; j<gioHang.size(); j++) {
				if (ngayTaoHoaDon.getTime() >= ngayBD.getTime() && ngayTaoHoaDon.getTime() <= ngayKT.getTime() && kmtheosach.getMaSach() == gioHang.get(j).getMaSach()) {
					rowData[hangKhuyenMai][0] = kmtheosach.getMa();
					rowData[hangKhuyenMai][1] = tenCT;
					rowData[hangKhuyenMai][2] = kmtheosach.getPhanTramKM() + "%";
					rowData[hangKhuyenMai][3] = ngayBD;
					rowData[hangKhuyenMai][4] = ngayKT;
					rowData[hangKhuyenMai][5] = kmtheosach.getMaSach();
					rowData[hangKhuyenMai][6] = formatGiaTien(0);
					hangKhuyenMai++;
				}
			}
		}

		for (int i = 0; i < dsKmTheoTongTien.size(); i++) {
			KhuyenMaiTheoTongTienDTO kmtheotongtien = dsKmTheoTongTien.get(i);
			String tenCT = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheotongtien.getMaChuongTrinh()).getTen();
			Date ngayBD = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheotongtien.getMaChuongTrinh()).getNgayBD();
			Date ngayKT = new ChuongTrinhKhuyenMai2BUS().layCTKhuyenMai(kmtheotongtien.getMaChuongTrinh()).getNgayKT();

			if (ngayTaoHoaDon.getTime() >= ngayBD.getTime() && ngayTaoHoaDon.getTime() <= ngayKT.getTime() && tongHoaDonBanDau >= kmtheotongtien.getDieuKienApDung()) {
//				rowData[dsKmTheoSach.size() + i][0] = kmtheotongtien.getMa();
//				rowData[dsKmTheoSach.size() + i][1] = tenCT;
//				rowData[dsKmTheoSach.size() + i][2] = kmtheotongtien.getPhanTramKM() + "%";
//				rowData[dsKmTheoSach.size() + i][3] = ngayBD;
//				rowData[dsKmTheoSach.size() + i][4] = ngayKT;
//				rowData[dsKmTheoSach.size() + i][5] = "______";
//				rowData[dsKmTheoSach.size() + i][6] = formatGiaTien(kmtheotongtien.getDieuKienApDung());
				rowData[hangKhuyenMai][0] = kmtheotongtien.getMa();
				rowData[hangKhuyenMai][1] = tenCT;
				rowData[hangKhuyenMai][2] = kmtheotongtien.getPhanTramKM() + "%";
				rowData[hangKhuyenMai][3] = ngayBD;
				rowData[hangKhuyenMai][4] = ngayKT;
				rowData[hangKhuyenMai][5] = "______";
				rowData[hangKhuyenMai][6] = formatGiaTien(kmtheotongtien.getDieuKienApDung());
				hangKhuyenMai++;
			}
		}

		NonEditableTableModel model = new NonEditableTableModel(rowData, columnNames);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

	}

	public static int laySoNguyen(String s) {
		return Integer.parseInt(s.replaceAll("[^0-9]", ""));
	}

	private boolean dungMaKmTheoSach(String maKm) {
		return maKm.contains("GGS");
	}

	private void xuLyClickDsKhuyenMai(JTable tblListKhuyenMai, JButton btnDungKM, JButton btnKhongDungKM,
			JPanel pnXuatHoaDon, JLabel lblNoteKM, JLabel lblTongTienSauKM) {
		Timestamp ngayTaoHoaDon = new java.sql.Timestamp(new java.util.Date().getTime());
		int row = tblListKhuyenMai.getSelectedRow();
		if (row > -1) {
			String maKM = (String) tblListKhuyenMai.getValueAt(row, 0);
			int coMaGiam = 0;
			if (dungMaKmTheoSach(maKM)) { // nếu chọn vào các mã giảm giá theo sách
				int maSachKM = (int) tblListKhuyenMai.getValueAt(row, 5);
				int phanTram = laySoNguyen((String) tblListKhuyenMai.getValueAt(row, 2));
				tongThanhToan = 0;
				int tong1LoaiSach;
				for (int i = 0; i < BanHangGUI.gioHang.size(); i++) {
					tong1LoaiSach = BanHangGUI.gioHang.get(i).getDonGia() * BanHangGUI.gioHang.get(i).getSoLuong();
					if (BanHangGUI.gioHang.get(i).getMaSach() == maSachKM) {
						tong1LoaiSach = tong1LoaiSach - ((tong1LoaiSach * phanTram) / 100);
						coMaGiam = 1;
					}
					tongThanhToan = tongThanhToan + tong1LoaiSach;
				}
				if (coMaGiam != 1) {
					btnDungKM.setVisible(false);
					thongBao = "*Hóa đơn không dùng mã giảm giá";
					JOptionPane.showMessageDialog(null, "Không áp dụng cho sản phẩm trong giỏ hàng");
					lblNoteKM.setText(thongBao);
				} else {
					btnDungKM.setVisible(true);
					thongBao = "*Hóa đơn đã áp dụng mã " + tblListKhuyenMai.getValueAt(row, 1);
				}
			} else { // nếu chọn vào các mã giảm theo tổng hđ
				int dieuKienApDung = laySoNguyen((String) tblListKhuyenMai.getValueAt(row, 6));
				int phanTram = laySoNguyen((String) tblListKhuyenMai.getValueAt(row, 2));
				Date ngayBD = (Date) tblListKhuyenMai.getValueAt(row, 3);
				Date ngayKT = (Date) tblListKhuyenMai.getValueAt(row, 4);
				int tongThanhToanBanDau = BanHangGUI.tongThanhToanBanDau;
				tongThanhToan = 0;
				if (tongThanhToanBanDau >= dieuKienApDung && (ngayTaoHoaDon.getTime() >= ngayBD.getTime()
						&& ngayTaoHoaDon.getTime() <= ngayKT.getTime())) {
					btnDungKM.setVisible(true);
					thongBao = "*Hóa đơn đã áp dụng mã " + tblListKhuyenMai.getValueAt(row, 1);
					tongThanhToan = tongThanhToanBanDau - ((tongThanhToanBanDau * phanTram) / 100);
				} else if (ngayTaoHoaDon.getTime() <= ngayBD.getTime()) {
					btnDungKM.setVisible(false);
					JOptionPane.showMessageDialog(null, "Mã giảm giá chưa có hiệu lực");
					lblNoteKM.setText("*Hóa đơn không dùng mã giảm giá");
				} else if (ngayTaoHoaDon.getTime() >= ngayKT.getTime()) {
					btnDungKM.setVisible(false);
					JOptionPane.showMessageDialog(null, "Mã giảm giá đã hết hiệu lực");
					lblNoteKM.setText("*Hóa đơn không dùng mã giảm giá");
				} else if ((ngayTaoHoaDon.getTime() >= ngayBD.getTime() && ngayTaoHoaDon.getTime() <= ngayKT.getTime())
						&& tongThanhToanBanDau <= dieuKienApDung) {
					btnDungKM.setVisible(false);
					JOptionPane.showMessageDialog(null, "Hóa đơn chưa đủ điều kiện để áp dụng");
					lblNoteKM.setText("*Hóa đơn không dùng mã giảm giá");
				}

			}

			btnDungKM.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					pnXuatHoaDon.setVisible(true);
					lblNoteKM.setText(thongBao);
					lblTongTienSauKM.setText(formatGiaTien(tongThanhToan) + "");
					lblNoteKM.setVisible(true);
				}
			});
		}

	}

	private void taoChiTietPhieuXuat(int maHD, chiTietGioHang chiTietGioHang) {
		int maPhieuXuat = maHD;
		int maSach = chiTietGioHang.getMaSach();
		int soLuong = chiTietGioHang.getSoLuong();
		int donGia = chiTietGioHang.getDonGia();
		int thanhTien = chiTietGioHang.getTongTien();
		ChiTietPhieuXuatDTO ctpx = new ChiTietPhieuXuatDTO(0, maPhieuXuat, maSach, soLuong, donGia, thanhTien);
		ChiTietPhieuXuatBUS ctpxBUS = new ChiTietPhieuXuatBUS();
		ctpxBUS.themChiTietPhieuXuat(ctpx);
	}

	private void giamSoLuongKho() {
		Sach2BUS sachBUS = new Sach2BUS();
		for (int i = 0; i < BanHangGUI.gioHang.size(); i++) {
			int maSach = BanHangGUI.gioHang.get(i).getMaSach();
			int soLuongDaBan = BanHangGUI.gioHang.get(i).getSoLuong();
			int soLuongKhoHienTai = sachBUS.getSach(maSach).getSoLuong();
			int soLuongKhoCapNhat = soLuongKhoHienTai - soLuongDaBan;
			sachBUS.updateSoLuong(maSach, soLuongKhoCapNhat);
		}
	}

	private void xuLyClickThanhToan() {
		Date ngayTao = new Date(0000, 0, 00);
		int maNV = ChonKhachHangNhanVien.maNhanVien;
		int maKH = ChonKhachHangNhanVien.maKhachHang;
		int tongThanhToanBanDau = BanHangGUI.tongThanhToanBanDau;
		PhieuXuatDTO px = new PhieuXuatDTO(0, ngayTao, maNV, maKH, tongThanhToanBanDau, tongThanhToan);
		PhieuXuatBUS pxBUS = new PhieuXuatBUS();
		pxBUS.themPhieuXuat(px);
		int maPX = pxBUS.maPhieuXuatMoiNhat();
		for (int i = 0; i < BanHangGUI.gioHang.size(); i++) {
			taoChiTietPhieuXuat(maPX, BanHangGUI.gioHang.get(i));
		}
		maPhieuXuatHienTai = maPX;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HienThiKhuyenMaiGUI frame = new HienThiKhuyenMaiGUI();
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
	public HienThiKhuyenMaiGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 981, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 58, 946, 240);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 946, 230);
		panel.add(scrollPane);

		tblListKhuyenMai = new JTable();
		scrollPane.setViewportView(tblListKhuyenMai);
		tblListKhuyenMai.setCellSelectionEnabled(true);
		tblListKhuyenMai.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblListKhuyenMai.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 gi\u1EA3m gi\u00E1", "\u01AFu \u0111\u00E3i", "T\u1EEB ng\u00E0y",
						"\u0110\u1EBFn ng\u00E0y", "\u0110\u1ED1i v\u1EDBi m\u00E3 s\u00E1ch",
						"D\u00E0nh cho h\u00F3a \u0111\u01A1n t\u1EEB" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class, Object.class, Object.class, Object.class,
					Object.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblListKhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(69);
		tblListKhuyenMai.getColumnModel().getColumn(1).setPreferredWidth(156);
		tblListKhuyenMai.getColumnModel().getColumn(2).setPreferredWidth(97);
		tblListKhuyenMai.getColumnModel().getColumn(3).setPreferredWidth(87);
		tblListKhuyenMai.getColumnModel().getColumn(4).setPreferredWidth(108);
		tblListKhuyenMai.getColumnModel().getColumn(5).setPreferredWidth(253);
		tblListKhuyenMai.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		tblListKhuyenMai.setColumnSelectionAllowed(true);
		tblListKhuyenMai.setFillsViewportHeight(true);
		tblListKhuyenMai.setForeground(new Color(0, 0, 0));
		tblListKhuyenMai.setSurrendersFocusOnKeystroke(true);
		tblListKhuyenMai.setBackground(SystemColor.controlHighlight);
		tblListKhuyenMai.setRowHeight(25);
		docListKhuyenMai(tblListKhuyenMai, BanHangGUI.gioHang, BanHangGUI.tongThanhToanBanDau);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 946, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lựa chọn 1 khuyến mãi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(339, 0, 197, 38);
		panel_1.add(lblNewLabel);

		JButton btnQuayLaiNhapHoaDon = new JButton("Quay lại");
		btnQuayLaiNhapHoaDon.setBounds(768, 5, 93, 30);
		panel_1.add(btnQuayLaiNhapHoaDon);
		btnQuayLaiNhapHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(97, 308, 325, 122);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnDungKM = new JButton("Dùng mã");
		btnDungKM.setBackground(new Color(0, 139, 139));
		btnDungKM.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDungKM.setBounds(57, 66, 209, 46);
		panel_2.add(btnDungKM);
		btnDungKM.setVisible(false);

		JButton btnKhongDungKM = new JButton("Không dùng mã");
		btnKhongDungKM.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnKhongDungKM.setBounds(57, 10, 209, 46);
		panel_2.add(btnKhongDungKM);

		JPanel pnXuatHoaDon = new JPanel();
		pnXuatHoaDon.setBounds(449, 347, 407, 173);
		contentPane.add(pnXuatHoaDon);
		pnXuatHoaDon.setLayout(null);
		pnXuatHoaDon.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Tổng thanh toán:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 10, 134, 27);
		pnXuatHoaDon.add(lblNewLabel_1);

		JLabel lblTongTienSauKM = new JLabel("");
		lblTongTienSauKM.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTongTienSauKM.setBounds(143, 10, 194, 27);
		pnXuatHoaDon.add(lblTongTienSauKM);

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(0, 139, 139));
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThanhToan.setBounds(217, 107, 134, 56);
		pnXuatHoaDon.add(btnThanhToan);

		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(42, 47, 102, 27);
		pnXuatHoaDon.add(lblNewLabel_1_1);

		JLabel lblTenKhachHang = new JLabel("");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenKhachHang.setBounds(143, 47, 194, 27);
		pnXuatHoaDon.add(lblTenKhachHang);
		lblTenKhachHang.setText(ChonKhachHangNhanVien.tenKhachHang);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(449, 308, 475, 29);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNoteKM = new JLabel("");
		lblNoteKM.setForeground(new Color(0, 128, 128));
		lblNoteKM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNoteKM.setBounds(10, 0, 454, 29);
		panel_3.add(lblNoteKM);
		lblNoteKM.setVisible(false);

		btnQuayLaiNhapHoaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HienThiKhuyenMaiGUI.this.dispose();
			}
		});

		tblListKhuyenMai.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyClickDsKhuyenMai(tblListKhuyenMai, btnDungKM, btnKhongDungKM, pnXuatHoaDon, lblNoteKM,
						lblTongTienSauKM);
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

		btnKhongDungKM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tongThanhToan = BanHangGUI.tongThanhToanBanDau;
				pnXuatHoaDon.setVisible(true);
				thongBao = "*Hóa đơn không dùng mã giảm giá";
				lblNoteKM.setText(thongBao);
				lblNoteKM.setVisible(true);
				lblTongTienSauKM.setText(formatGiaTien(BanHangGUI.tongThanhToanBanDau) + "");
			}
		});

		btnThanhToan.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyClickThanhToan();
				giamSoLuongKho();
				XuatHoaDon manHinhXuatHD = new XuatHoaDon();
				manHinhXuatHD.setLocationRelativeTo(HienThiKhuyenMaiGUI.this);
				manHinhXuatHD.setVisible(true);
				HienThiKhuyenMaiGUI.this.setVisible(false);
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

	}
}
