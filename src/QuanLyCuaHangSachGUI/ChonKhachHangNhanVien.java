package QuanLyCuaHangSachGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import QuanLyCuaHangSachBUS.KhachHangBUS;
import QuanLyCuaHangSachBUS.NhanVienBUS;
import QuanLyCuaHangSachDTO.KhachHangDTO;
import QuanLyCuaHangSachDTO.NhanVienDTO;

public class ChonKhachHangNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int maKhachHang;
	public static int maNhanVien;
	public static String tenKhachHang;
	public static String tenNhanVien;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;

	public int layMa(String input) {
		return Integer.parseInt(input.substring(0, input.indexOf(" ")));
	}

	public String layTen(String input) {
		int i = input.indexOf(" ", input.indexOf(" ") + 1);
		return input.substring(i + 1);
	}

	public String xoaKhoangTrangThua(String input) {
		String s = input.replaceAll("\\s+", " ");
		return s.trim();
	}

	public boolean nhapDayDu(String ho, String ten, String diachi, String sdt) {
		if (xoaKhoangTrangThua(ho).equals("") || xoaKhoangTrangThua(ten).equals("")
				|| xoaKhoangTrangThua(diachi).equals("") || xoaKhoangTrangThua(sdt).equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkDinhDangSDT(String sdt) {
		sdt = sdt.replaceAll("[^0-9]", "");
		if ((sdt.length() != 10) || (sdt.charAt(0) != '0'))
			return false;
		return true;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChonKhachHangNhanVien frame = new ChonKhachHangNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 *
	 * Create the frame.
	 */
	public ChonKhachHangNhanVien() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnTong = new JPanel();
		pnTong.setBounds(10, 10, 674, 201);
		contentPane.add(pnTong);
		pnTong.setLayout(null);

		JButton btnTiepTuc = new JButton("Tiếp tục");
		btnTiepTuc.setBackground(new Color(0, 139, 139));
		btnTiepTuc.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnTiepTuc.setBounds(361, 149, 137, 42);
		pnTong.add(btnTiepTuc);

		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuayLai.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnQuayLai.setBounds(181, 149, 137, 42);
		pnTong.add(btnQuayLai);

		JPanel pnNhapThongTinKhachHangMoi = new JPanel();
		pnNhapThongTinKhachHangMoi.setBounds(10, 8, 654, 131);
		pnTong.add(pnNhapThongTinKhachHangMoi);
		pnNhapThongTinKhachHangMoi.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 242, 25);
		pnNhapThongTinKhachHangMoi.add(lblNewLabel);

		JLabel lblH = new JLabel("Họ: ");
		lblH.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblH.setBounds(10, 41, 38, 25);
		pnNhapThongTinKhachHangMoi.add(lblH);

		JLabel lblTn = new JLabel("Tên: ");
		lblTn.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblTn.setBounds(10, 79, 38, 25);
		pnNhapThongTinKhachHangMoi.add(lblTn);

		JLabel lblaCh = new JLabel("Địa chỉ: ");
		lblaCh.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblaCh.setBounds(251, 41, 61, 25);
		pnNhapThongTinKhachHangMoi.add(lblaCh);

		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblSinThoi.setBounds(222, 76, 90, 25);
		pnNhapThongTinKhachHangMoi.add(lblSinThoi);

		txtHo = new JTextField();
		txtHo.setBounds(45, 38, 133, 25);
		pnNhapThongTinKhachHangMoi.add(txtHo);
		txtHo.setColumns(10);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(45, 76, 133, 25);
		pnNhapThongTinKhachHangMoi.add(txtTen);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(319, 38, 148, 25);
		pnNhapThongTinKhachHangMoi.add(txtDiaChi);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(322, 76, 145, 25);
		pnNhapThongTinKhachHangMoi.add(txtSDT);

		JButton btnLuuKhachHangMoi = new JButton("Thêm");
		btnLuuKhachHangMoi.setBackground(new Color(0, 139, 139));
		btnLuuKhachHangMoi.setForeground(new Color(0, 0, 0));
		btnLuuKhachHangMoi.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		btnLuuKhachHangMoi.setBounds(547, 28, 76, 35);
		pnNhapThongTinKhachHangMoi.add(btnLuuKhachHangMoi);

		JButton btnHuyThemKhachHangMoi = new JButton("Hủy");
		btnHuyThemKhachHangMoi.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		btnHuyThemKhachHangMoi.setBounds(547, 69, 76, 35);
		pnNhapThongTinKhachHangMoi.add(btnHuyThemKhachHangMoi);

		JPanel pnComboBox = new JPanel();
		pnComboBox.setBounds(10, 25, 654, 114);
		pnTong.add(pnComboBox);
		pnComboBox.setLayout(null);

		JLabel lblNewLabel1 = new JLabel("Khách hàng: ");
		lblNewLabel1.setBounds(89, 30, 99, 31);
		pnComboBox.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Palatino Linotype", Font.BOLD, 13));

		JLabel lblNhnVinLp = new JLabel("Nhân viên lập hóa đơn: ");
		lblNhnVinLp.setBounds(23, 71, 165, 31);
		pnComboBox.add(lblNhnVinLp);
		lblNhnVinLp.setFont(new Font("Palatino Linotype", Font.BOLD, 13));

		JComboBox cbbKhachHang = new JComboBox();
		cbbKhachHang.setBounds(191, 32, 240, 26);
		pnComboBox.add(cbbKhachHang);
		cbbKhachHang.setFont(new Font("Palatino Linotype", Font.BOLD, 13));

		JComboBox cbbNhanVien = new JComboBox();
		cbbNhanVien.setBounds(191, 73, 240, 26);
		pnComboBox.add(cbbNhanVien);
		cbbNhanVien.setFont(new Font("Palatino Linotype", Font.BOLD, 13));

		JButton btnThemKhachHang = new JButton("Thêm khách hàng mới");
		btnThemKhachHang.setBounds(457, 30, 197, 31);
		pnComboBox.add(btnThemKhachHang);
		btnThemKhachHang.setFont(new Font("Palatino Linotype", Font.BOLD, 15));

		NhanVienBUS nhanvienBUS = new NhanVienBUS();
		ArrayList<NhanVienDTO> listNhanVien = nhanvienBUS.getDanhSachNhanVien();
		for (NhanVienDTO nhanvien : listNhanVien) {
			cbbNhanVien.addItem(nhanvien.getmaNV() + " - " + nhanvien.getho() + " " + nhanvien.getten());
		}
		KhachHangBUS khachhangBUS = new KhachHangBUS();
		ArrayList<KhachHangDTO> listKhachHang = khachhangBUS.getDanhSachKhachHang();
		for (int i = listKhachHang.size() - 1; i >= 0; i--) {
			KhachHangDTO khachhang = listKhachHang.get(i);
			cbbKhachHang.addItem(khachhang.getmaKH() + " - " + khachhang.getho() + " " + khachhang.getten());
		}

		pnTong.remove(pnNhapThongTinKhachHangMoi);
		pnTong.revalidate();
		pnTong.repaint();
		btnTiepTuc.setVisible(true);

		btnThemKhachHang.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTong.remove(pnComboBox);
				pnTong.add(pnNhapThongTinKhachHangMoi);
				pnTong.revalidate();
				pnTong.repaint();
				btnTiepTuc.setVisible(false);
				btnQuayLai.setVisible(false);

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

		btnHuyThemKhachHangMoi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTong.remove(pnNhapThongTinKhachHangMoi);
				pnTong.add(pnComboBox);
				pnTong.revalidate();
				pnTong.repaint();
				btnTiepTuc.setVisible(true);

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

		btnLuuKhachHangMoi.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hoKH = txtHo.getText();
				String tenKH = txtTen.getText();
				String diaChiKH = txtDiaChi.getText();
				String sdtKH = txtSDT.getText();
				if (!nhapDayDu(hoKH, tenKH, diaChiKH, sdtKH)) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ các trường");
				} else if ((nhapDayDu(hoKH, tenKH, diaChiKH, sdtKH)) && (!checkDinhDangSDT(sdtKH))) {
					JOptionPane.showMessageDialog(null, "Số điện thoại chưa đúng định dạng");
				} else if ((nhapDayDu(hoKH, tenKH, diaChiKH, sdtKH)) && (checkDinhDangSDT(sdtKH))) {
					ArrayList<KhachHangDTO> listKhachHang = khachhangBUS.getDanhSachKhachHang();
					boolean tonTaiKhachHang = false;
					for (KhachHangDTO khachHang : listKhachHang) {
						if (khachHang.getho().equalsIgnoreCase(hoKH) && khachHang.getten().equalsIgnoreCase(tenKH)
								&& khachHang.getdiaChi().equalsIgnoreCase(diaChiKH)
								&& khachHang.getsdt().equals(sdtKH)) {
							tonTaiKhachHang = true;
							break;
						}
					}

					if (tonTaiKhachHang) {
						JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại !");
					} else {
						KhachHangBUS khachHangBUS = new KhachHangBUS();
						khachHangBUS.themKhachHang(hoKH, tenKH, diaChiKH, sdtKH);
						pnTong.remove(pnNhapThongTinKhachHangMoi);
						pnTong.add(pnComboBox);
						pnTong.revalidate();
						pnTong.repaint();
						btnTiepTuc.setVisible(true);
						cbbKhachHang.removeAllItems();
						KhachHangBUS khachhangBUS = new KhachHangBUS();

						for (int i = listKhachHang.size() - 1; i >= 0; i--) {
							KhachHangDTO khachhang = listKhachHang.get(i);
							cbbKhachHang.addItem(
									khachhang.getmaKH() + " - " + khachhang.getho() + " " + khachhang.getten());
						}
					}

				}

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

		btnTiepTuc.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maKhachHang = layMa(cbbKhachHang.getSelectedItem().toString());
				tenKhachHang = layTen(cbbKhachHang.getSelectedItem().toString());
				maNhanVien = layMa(cbbNhanVien.getSelectedItem().toString());
				tenNhanVien = layTen(cbbNhanVien.getSelectedItem().toString());
				HienThiKhuyenMaiGUI khuyenmai = new HienThiKhuyenMaiGUI();
				khuyenmai.setLocationRelativeTo(ChonKhachHangNhanVien.this);
				khuyenmai.setVisible(true);
				ChonKhachHangNhanVien.this.setVisible(false);

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

		btnQuayLai.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChonKhachHangNhanVien.this.setVisible(false);

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
