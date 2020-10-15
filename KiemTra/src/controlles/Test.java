package controlles;

import commoms.FileUtils;
import models.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static Scanner scanner = new Scanner(System.in);
    public static List<SinhVien> sinhVienList = new ArrayList<>();
    public static final String COMA = ",";
    public static final String FILE_STUDENT = "D:\\KiemTra\\src\\data\\sinhvien.csv";

    public static void trinhDon() {
        int chon = 1;
        do {
            System.out.println("-------------------------" + "\n" +
                    "1.Thêm sinh viên" + "\n" +
                    "2.Xóa sinh viên" + "\n" +
                    "3.Hiển thị sinh viên" + "\n" +
                    "4.Hiển thị giáo viên" + "\n" +
                    "5.Tìm kiếm sinh viên" + "\n" +
                    "6.Xóa" + "\n" +
                    "---------------------------");
            System.out.print("Nhập chọn:");
            int nhapChon = Integer.parseInt(scanner.nextLine());
            switch (nhapChon) {
                case 1:
                   Them.themSinhVien();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1-6");
                    break;
            }
        }while (chon >=1 && chon <= 6);
    }

    public static void main(String[] args) {
        List<String> stringList = FileUtils.readFile(FILE_STUDENT);
        for (String s :stringList){
            String[] listSlit = s.split(",");
            SinhVien sinhVien = new SinhVien(Integer.parseInt(listSlit[0]), listSlit[1], listSlit[2], listSlit[3],
                    Integer.parseInt(listSlit[4]), listSlit[5]);
            sinhVienList.add(sinhVien);
        }
        trinhDon();
    }
}
