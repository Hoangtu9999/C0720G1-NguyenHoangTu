package _15_xu_ly_ngoai_le_va_debug.bai_tap.xu_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class TriangleTest {
    public static void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhâp vào cạnh a:");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào cạnh b:");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào cạnh c:");
        int c = Integer.parseInt(scanner.nextLine());
        if (a < 0 || b < 0 || c < 0 || a + b < c || a + c < b || b + c < a) {
            try {
                throw new NegativeException("Không được nhập vào số âm!");
            } catch (NegativeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        inputData();

    }
}
