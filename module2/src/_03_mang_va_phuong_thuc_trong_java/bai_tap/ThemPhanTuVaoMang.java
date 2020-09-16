package _03_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng :");
        size = scanner.nextInt();
        int array[] = new int[size * 2];
        for (int i = 0; i <= size -1 ; i++) {
            System.out.print("Nhập Phần tử " + (i + 1) + " là :");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhập Phần tử cần chèn");
        int k = scanner.nextInt();
        System.out.printf("\n chèn phần tư %d vào mảng ", k);
        System.out.print("Nhập vị trí chèn ");
        int index = scanner.nextInt();
        System.out.printf("\n vị trí chèn tại %d ", index);
        for (int i = array.length - 1; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = k;
        System.out.println(Arrays.toString(array));
    }
}