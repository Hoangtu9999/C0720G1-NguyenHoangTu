package commoms;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+(\\.\\d+)?");
    }

    public static String kiemTraNhapSo(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapThongTin) && Float.parseFloat(nhapThongTin) > 0) break;
            else System.err.println("Thông tin không hợp lệ !");
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraNhapChu(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("")) System.err.println("Thông tin không được bỏ trống !");
            else break;
        } while (true);
        return nhapThongTin;
    }
    public static void kiemTraNgaySinh(String ngaySinh) throws HandleException {
        String regex = "^([0][1-9]|[12][0-9]|[3][01])/([0][1-9]|[1][012])/(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ngaySinh);
        if (!matcher.find())
            throw new HandleException("Số ngày sinh phải đúng định dạng dd/mm/yyyy ");
    }
    public static void kiemTraSoDienThoai(String soDienThoai) throws HandleException {
        String regex = "(090|091)\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(soDienThoai);
        if (!matcher.find())
            throw new HandleException("Số điện thoại không đúng định dạng ");
    }
}
