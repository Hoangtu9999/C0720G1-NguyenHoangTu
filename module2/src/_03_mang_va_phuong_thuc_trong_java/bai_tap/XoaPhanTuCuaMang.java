package _03_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class XoaPhanTuCuaMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mãng:");
        int input = scanner.nextInt();
        int[] n = new int[input];
        for (int i = 0 ; i < input ; i++){
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            n[i] = scanner.nextInt();
        }
        System.out.println("Nhập phần tử cần xóa:");
        int x = scanner.nextInt();
        int c,j;
        for (c = j = 0 ; j < input ;j++){
            if(n[j] != x){
                n[c] = n[j];
                c++;
            }
        }
        input = c;
        System.out.println("Mảng còn lại sau khi xóa phần tử " + x + " là: ");
        for (int i = 0; i < input; i++) {
            System.out.print(n[i] + "\t");
        }
    }
}
