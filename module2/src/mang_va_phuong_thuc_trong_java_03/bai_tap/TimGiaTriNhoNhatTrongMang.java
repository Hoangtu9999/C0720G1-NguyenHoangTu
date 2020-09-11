package mang_va_phuong_thuc_trong_java_03.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int m;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng: ");
        m = scanner.nextInt();
        int A[] = new int[m];
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < m; i++) {
                System.out.print("A[" + i + "] = ");
                A[i] = scanner.nextInt();
            }

        int min = A[0];
        for (int i = 0; i < m; i++) {
                if (min > A[i]) {
                    min = A[i];
                }
            }


        System.out.println("Phần tử nhỏ nhất trong mảng = " + min);
    }
}



