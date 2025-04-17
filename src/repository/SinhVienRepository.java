package repository;

import java.util.List;
import entity.SinhVien;
import java.util.ArrayList;
import java.sql.*;
import utils.KetNoiDB;

public class SinhVienRepository {
    public static List<SinhVien> readSinhVien() {
        String sql = "SELECT * FROM SinhVien";
        
        List<SinhVien> sinhVienLst = new ArrayList<SinhVien>();
        
        try (Connection con = KetNoiDB.getConnectDB();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String maSV = rs.getString("Ma");
                String tenSV = rs.getString("Ten");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                int tuoi = rs.getInt("Tuoi");
                
                SinhVien sinhVien = new SinhVien(maSV, tenSV, gioiTinh, tuoi);
                sinhVienLst.add(sinhVien);
            }
            return sinhVienLst;
            
        } catch (Exception e) {
            return sinhVienLst;
        }
    }
    
    public static SinhVien readSinhVienCuoiCung() {
        List<SinhVien> sinhVienLst = readSinhVien();
        
        SinhVien sinhVienCuoiCung;
        
        if (sinhVienLst.size() != 0) {
            sinhVienCuoiCung = sinhVienLst.get(sinhVienLst.size() - 1);
            return sinhVienCuoiCung;
        }
        
        sinhVienCuoiCung = new SinhVien();
        return sinhVienCuoiCung;
    }
    
    public static int createSinhVien(SinhVien sinhVien) {
        String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?);";
        
        try (Connection con = KetNoiDB.getConnectDB();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, sinhVien.getMaSV());
            ps.setString(2, sinhVien.getTenSV());
            ps.setBoolean(3, sinhVien.isGioiTinh());
            ps.setInt(4, sinhVien.getTuoi());
            
            int ketQua = ps.executeUpdate();
            return ketQua;
            
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
