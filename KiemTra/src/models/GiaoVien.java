package models;

public class GiaoVien extends ConNguoi {

    public GiaoVien(int id, String ten, String ngaySinh, String gioiTinh, int soDienThoai) {
        super(id, ten, ngaySinh, gioiTinh, soDienThoai);
    }

    public GiaoVien() {
    }


    @Override
    public void showInfo() {
        this.toString();
    }
}
