package _03_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array_1 = new int[5];
        int[] array_2 = new int[5];
        int[] array_3 = new int[array_1.length + array_2.length];
        for (int i = 0; i < array_1.length; i++) {
            System.out.print("Nhập phần thứ " + (i + 1) + " của mảng array_1 :");
            array_1[i] = scanner.nextInt();
            array_3[i] = array_1[i];
        }
        for (int j = 0; j < array_2.length; j++) {
            System.out.print("Nhập phần thứ " + (j + 1) + " của mảng array_2 :");
            array_2[j] = scanner.nextInt();
            array_3[array_1.length+j] = array_2[j];
        }
        System.out.println("Mảng mới sau khi gộp 2 mảng có " + array_3.length + ": ");
        for (int k = 0; k < array_3.length; k++) {
            System.out.print(array_3[k] + "\t");
        }

    }
}
