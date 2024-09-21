//package QuanLyCuaHangSach.BUS;
//import java.util.ArrayList;
//import java.util.Date;
//
//import QuanLyCuaHangSach.DAO.PhieuNhapDAO;
//import QuanLyCuaHangSach.DTO.PhieuNhapDTO;
//
//public class PhieuNhapBUS {
//	public static ArrayList<PhieuNhapDTO> dsphieunhap;
//
//	public void themPhieu(PhieuNhapDTO pn) {
//		if (dsphieunhap == null) {
//			dsphieunhap = new ArrayList<>();
//	    }
//		PhieuNhapDAO pnDAO = new PhieuNhapDAO();
//		pnDAO.themPhieu(pn);
//		dsphieunhap.add(pn);
//	}
//
//	 public void docPhieuNhap(PhieuNhapDTO pn) {
//	        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
//	        if (dsphieunhap == null) {
//	        	dsphieunhap = new ArrayList<>();
//	        }
//	        ArrayList<PhieuNhapDTO> dsPN = pnDAO.docdsPhieu();
//	        dsphieunhap.addAll(dsPN);
//	 }
//
//	 public ArrayList<PhieuNhapDTO> timkiemTheoNgay(Date min2, Date max2) {
//		    try {
//		        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
//		        for (PhieuNhapDTO pn : dsphieunhap) {
//		            if (pn.getNgaylap().compareTo(max2) <= 0 && pn.getNgaylap().compareTo(min2) >= 0) {
//		                result.add(pn);
//		            }
//		        }
//		        return result;
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		    }
//		    return null;
//		}
//}



package QuanLyCuaHangSachBUS;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import QuanLyCuaHangSachDAO.NhanVienDAO;
import QuanLyCuaHangSachDAO.PhieuNhapDAO;
import QuanLyCuaHangSachDAO.Sach2DAO;
import QuanLyCuaHangSachDTO.NhanVienDTO;
import QuanLyCuaHangSachDTO.PhieuNhapDTO;
import QuanLyCuaHangSachDTO.Sach2DTO;



public class PhieuNhapBUS {
	public static ArrayList<PhieuNhapDTO> dsphieunhap;
	public void danhsachNhanVien(JComboBox model) {
		model.removeAllItems();
		NhanVienDAO nv=new NhanVienDAO();
        ArrayList<NhanVienDTO> result=nv.getDanhSachNhanVien();
        for (NhanVienDTO tk : result) {
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
    }
	public void danhsachSach(JComboBox model) {
		model.removeAllItems();
		Sach2DAO sachDao = new Sach2DAO();
		ArrayList<Sach2DTO> dsSach = sachDao.getListSach();
		// if (dsSach == null || dsSach.isEmpty()) {
		// 	sachBUS.docSach();
		// 	dsSach = sachBUS.getListSach();
		// }
        for (Sach2DTO tk : dsSach) {
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
    }
	public int getMaSach(String item){
		int maSach=0;
		String[] parts = item.split("-");
		String maSachString = parts[0];
		maSach = Integer.parseInt(maSachString);
		return maSach;
	}
	public void loadDonGia(JTextField text,String item){
		int maSach=getMaSach(item);
		Sach2DAO sachdao=new Sach2DAO();
		Sach2DTO result=sachdao.getSachById(maSach);
		text.setText(result.getDonGia()+"");
	}

	public int themMaPhieuNhap(){
		int maKeTiep=0;
		PhieuNhapDAO pnDAO = new PhieuNhapDAO();
		maKeTiep=pnDAO.getMaPhieuNhapMax()+1;
		return maKeTiep;
	}

	public void themPhieu(PhieuNhapDTO pn) {
		if (dsphieunhap == null) {
			dsphieunhap = new ArrayList<>();
	    }
		PhieuNhapDAO pnDAO = new PhieuNhapDAO();
		pnDAO.themPhieu(pn);
		dsphieunhap.add(pn);
	}

	 public void docPhieuNhap(PhieuNhapDTO pn) {
	        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
	        if (dsphieunhap == null) {
	        	dsphieunhap = new ArrayList<>();
	        }
	        ArrayList<PhieuNhapDTO> dsPN = pnDAO.docdsPhieu();
	        dsphieunhap.addAll(dsPN);
	 }

	 public ArrayList<PhieuNhapDTO> timkiemTheoNgay(Date min2, Date max2) {
		    try {
		        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
		        for (PhieuNhapDTO pn : dsphieunhap) {
		            if (pn.getNgaylap().compareTo(max2) <= 0 && pn.getNgaylap().compareTo(min2) >= 0) {
		                result.add(pn);
		            }
		        }
		        return result;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
		}
}
