package _06_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh :");
        double side1 = scanner.nextDouble();
        System.out.println("Nhập cạnh :");
        double side2 = scanner.nextDouble();
        System.out.println("Nhập cạnh :");
        double side3 = scanner.nextDouble();
        System.out.println("Nhập màu:");
        scanner.nextLine();
        String color = scanner.nextLine();


        Triangle triangle = new Triangle(side1,side2,side3,color);
        System.out.println(triangle);
    }
}
