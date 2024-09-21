package QuanLyCuaHangSachBUS;

import java.util.ArrayList;

import QuanLyCuaHangSachDAO.KhuyenMaiTheoTongTienDAO;
import QuanLyCuaHangSachDTO.KhuyenMaiTheoTongTienDTO;

public class KhuyenMaiTheoTongTienBUS {
	private KhuyenMaiTheoTongTienDAO khuyenMaiTheoTongTien;
	private ArrayList<KhuyenMaiTheoTongTienDTO> dsKhuyenMaiTheoTongTien;

	public KhuyenMaiTheoTongTienBUS() {
		khuyenMaiTheoTongTien = new KhuyenMaiTheoTongTienDAO();
		dsKhuyenMaiTheoTongTien = new ArrayList<>();
	}

	public void docKhuyenMaiTheoTongTien() {
		dsKhuyenMaiTheoTongTien = KhuyenMaiTheoTongTienDAO.getListKMTheoTongTien();
	}

	public ArrayList<KhuyenMaiTheoTongTienDTO> getListKhuyenMaiTheoTongTien() {
		return dsKhuyenMaiTheoTongTien;
	}

	public KhuyenMaiTheoTongTienDTO layKhuyenMaiTheoTongTien(int maCTKM) {
		return khuyenMaiTheoTongTien.getKMTheoTongTien(maCTKM);
	}
}
