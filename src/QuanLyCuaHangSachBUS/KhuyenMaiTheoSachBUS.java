package QuanLyCuaHangSachBUS;

import java.util.ArrayList;

import QuanLyCuaHangSachDAO.KhuyenMaiTheoSachDAO;
import QuanLyCuaHangSachDTO.KhuyenMaiTheoSachDTO;

public class KhuyenMaiTheoSachBUS {
	private KhuyenMaiTheoSachDAO khuyenMaiTheoSach;
	private ArrayList<KhuyenMaiTheoSachDTO> dsKhuyenMaiTheoSach;

	public KhuyenMaiTheoSachBUS() {
		khuyenMaiTheoSach = new KhuyenMaiTheoSachDAO();
		dsKhuyenMaiTheoSach = new ArrayList<>();
	}

	public void docKhuyenMaiTheoSach() {
		dsKhuyenMaiTheoSach = KhuyenMaiTheoSachDAO.getListKMTheoSach();
	}

	public ArrayList<KhuyenMaiTheoSachDTO> getListKhuyenMaiTheoSach() {
        return dsKhuyenMaiTheoSach;
    }

	public KhuyenMaiTheoSachDTO layKhuyenMaiTheoSach(int maCTKM, int maSach) {
		return khuyenMaiTheoSach.getKMTheoSach(maCTKM, maSach);
	}
}
