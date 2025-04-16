package entity;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private boolean gioiTinh;
    private int tuoi;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, boolean gioiTinh, int tuoi) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int namSinh) {
        this.tuoi = namSinh;
    }
    
    
}
