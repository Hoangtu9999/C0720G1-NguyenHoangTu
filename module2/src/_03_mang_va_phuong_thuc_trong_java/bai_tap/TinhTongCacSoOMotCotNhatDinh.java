package _03_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotNhatDinh {
    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số dòng của mảng: ");
        m = scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng: ");
        n = scanner.nextInt();

        int[][] A = new int[m][n];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }
//        System.out.print("Nhập cột cần tính tổng:");
//        int h = scanner.nextInt();
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                sum += A[k][j];
            }
            System.out.println("Tổng cột" + j + " :" + sum);
        }

    }
}
