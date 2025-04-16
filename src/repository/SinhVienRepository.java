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
}
