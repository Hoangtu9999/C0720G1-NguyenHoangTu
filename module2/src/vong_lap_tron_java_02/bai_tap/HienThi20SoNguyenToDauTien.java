package vong_lap_tron_java_02.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số:");
        int numbers = input.nextInt();
        int count = 0;
        int n = 2;
        if (numbers <= 0) {
            System.out.println("Hãy nhập số dương");
        } else {
            while (count < numbers) {
                int mark = 1;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        mark = 0;
                        break;
                    }
                }
                if (mark == 1) {
                    count++;
                    System.out.println(" " + n);
                }
                n++;
            }
        }

    }
}
