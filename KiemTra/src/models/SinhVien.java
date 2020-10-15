package models;

public class SinhVien extends ConNguoi {
    private String maLop;

    public SinhVien(int id, String ten, String ngaySinh, String gioiTinh, int soDienThoai, String maLop) {
        super(id, ten, ngaySinh, gioiTinh, soDienThoai);
        this.maLop = maLop;
    }

    public SinhVien() {
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maLop='" + maLop + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        this.toString();
    }
}
