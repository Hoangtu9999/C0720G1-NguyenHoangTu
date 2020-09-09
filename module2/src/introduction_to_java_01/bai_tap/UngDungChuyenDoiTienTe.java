package introduction_to_java_01.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số tiền cần đổi:");

        double USA = input.nextDouble();
        double VND = 23000;
        double rate = USA * VND;
        System.out.println(USA + " đô la = " + rate + " đ");
    }
}
