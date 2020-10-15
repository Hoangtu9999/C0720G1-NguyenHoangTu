package controlles;

import commoms.FileUtils;
import commoms.HandleException;
import commoms.Regex;
import models.SinhVien;

import java.util.List;

public class Them {
    public static void themSinhVien() {
        List<String> list = FileUtils.readFile(Test.FILE_STUDENT);
        int id = capNhatBienDem();
        boolean kiemTra = false;
        String tenSV;
        do {
            tenSV = Regex.kiemTraNhapChu(" tên sv");
        } while (!(tenSV.length() > 4 && tenSV.length() < 50));

        String ngaySinh = null;
        do {
            try {
                kiemTra = true;
                ngaySinh = Regex.kiemTraNhapChu(" ngày sinh sv");
                Regex.kiemTraNgaySinh(ngaySinh);

            } catch (HandleException e) {
                System.err.println(e.getMessage());
                kiemTra = false;
            }
        } while (!kiemTra);

        String gioiTinh = Regex.kiemTraNhapChu(" giới tính sv");

        String soDienThoai = null;
        do {
            try {
                kiemTra = true;
                soDienThoai = Regex.kiemTraNhapSo(" sdt sv");

                Regex.kiemTraSoDienThoai(soDienThoai);
            } catch (HandleException e) {
                System.err.println(e.getMessage());
                kiemTra = false;
            }
            for (SinhVien sinhVien : Test.sinhVienList){
                if (soDienThoai.equals(sinhVien.getSoDienThoai())){
                    System.err.println("Số điện thoại đã trùng!");
                    kiemTra = false;
                    break;
                }
            }
        } while (!kiemTra);

        String maLop = Regex.kiemTraNhapChu("mã lớp");

        SinhVien sinhVien = new SinhVien(id, tenSV, ngaySinh, gioiTinh, Integer.parseInt(soDienThoai), maLop);
        Test.sinhVienList.add(sinhVien);
        System.err.println("Nhập thành công");
    }


    public static int capNhatBienDem() {
        int bienDemID;
        List<String> list = FileUtils.readFile(Test.FILE_STUDENT);
        for (String string : list) {
            String[] listSlit = string.split(",");
            SinhVien sinhVien = new SinhVien(Integer.parseInt(listSlit[0]), listSlit[1], listSlit[2], listSlit[3],
                    Integer.parseInt(listSlit[4]), listSlit[5]);
            Test.sinhVienList.add(sinhVien);
        }
        if (Test.sinhVienList.isEmpty()) bienDemID = 1;
        else {
            int id = Test.sinhVienList.get(list.size() - 1).getId();
            bienDemID = id + 1;
        }
        return bienDemID;

    }
}
