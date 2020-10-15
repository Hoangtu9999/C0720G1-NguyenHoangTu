package thuc_don;


import dung_chung.FileUntil;
import lop.LopHoc;
import lop.SinhVien;
import validate.NgaySinhException;
import validate.SoDienThoaiException;
import validate.TenException;
import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class ThemSinhVien {
    public static void themMoiSinhVien() {
        DocFile.docFileBatch();
        DocFile.docFileSinhVien();
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        int idSinhVien = capNhatBienDem();

        String tenSinhVien = null;
        do {
            flag = true;
            try {
                System.out.print("Nhap ten sinh vien: ");
                tenSinhVien = scanner.nextLine();
                Validate.kiemTraTen(tenSinhVien);
            } catch (TenException e) {
                e.printStackTrace();
                flag = false;
            }
        } while (!flag);

        String ngaySinh = null;
        do {
            flag = true;
            try {
                System.out.print("Nhap ngay sinh: ");
                ngaySinh = scanner.nextLine();
                Validate.kiemTraNgaySinh(ngaySinh);
            } catch (NgaySinhException e) {
                e.printStackTrace();
                flag = false;
            }
        } while (!flag);


        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();


        String soDienThoai = null;
        do {
            flag = true;
            try {
                System.out.print("Nhap so dien thoai: ");
                soDienThoai = scanner.nextLine();
                Validate.kiemTraSoDienThoai(soDienThoai);
            } catch (SoDienThoaiException e) {
                e.printStackTrace();
                flag = false;
            }

            for (SinhVien sinhVien : ThucDonChinh.sinhVienList) {
                if (sinhVien.getSoDienThoai().equals(soDienThoai)) {
                    System.out.println("So dien thoai da ton tai !!!");
                    flag = false;
                    break;
                }
            }
        } while (!flag);

        int idLopHoc;
        do {
            flag = false;
            System.out.print("Nhap ma lop hoc: ");
            idLopHoc = scanner.nextInt();
            for (LopHoc lopHoc : ThucDonChinh.lopHocList) {
                if (lopHoc.getIdLopHoc() == idLopHoc) {
                    flag = true;
                    break;
                }
            }
            if (flag == true){
                break;
            }
            System.out.println("Ma lop hoc khong ton tai");
        } while (true);


        SinhVien sinhVien = new SinhVien(idSinhVien, tenSinhVien, ngaySinh, gioiTinh, soDienThoai, idLopHoc);

        String line = sinhVien.getId() + ThucDonChinh.COMA + sinhVien.getHoVaTen() + ThucDonChinh.COMA +
                sinhVien.getNgaySinh() + ThucDonChinh.COMA + sinhVien.getGioiTinh() + ThucDonChinh.COMA +
                sinhVien.getSoDienThoai() + ThucDonChinh.COMA + sinhVien.getIdLopHoc();

        ThucDonChinh.listLine = FileUntil.readFile(ThucDonChinh.FILE_SINHVIEN);
        ThucDonChinh.listLine.add(line);
        FileUntil.writeFile(ThucDonChinh.FILE_SINHVIEN, ThucDonChinh.listLine);
        System.out.println("Them thanh cong");
    }

    public static int capNhatBienDem() {
        int bienDemID;
        List<String> list = FileUntil.readFile(ThucDonChinh.FILE_SINHVIEN);
        for (String string : list) {
            String[] listSlit = string.split(",");
            SinhVien sinhVien = new SinhVien(Integer.parseInt(listSlit[0]), listSlit[1], listSlit[2], listSlit[3],
                    listSlit[4], Integer.parseInt(listSlit[5]));
            ThucDonChinh.sinhVienList.add(sinhVien);
        }
        if (ThucDonChinh.sinhVienList.isEmpty()) {
            bienDemID = 1;
        } else {
            int id = ThucDonChinh.sinhVienList.get(list.size() - 1).getId();
            bienDemID = id + 1;
        }
        return bienDemID;

    }

}
