package _02_vong_lap_tron_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        System.out.println("Menu");
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle ");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        Scanner input = new Scanner(System.in);
        int nhapSo = input.nextInt();
        while (nhapSo != 4) {
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle ");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            nhapSo = input.nextInt();
            switch (nhapSo) {
                case 1:
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 7; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" * ");
                        }
                        System.out.print("\n");
                    }
                    for (int i = 7; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    int n = 5;
                    int q = 0;
                    while (n > 0) {
                        for (int i = 1; i < n; i++) {
                            System.out.print(" ");

                        }
                        for (int j = 0; j <= q; j++) {
                            System.out.print("*");
                        }

                        n--;
                        q += 2;
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("Vui lòng nhập từ 1-4");
            }
        }
    }
}
