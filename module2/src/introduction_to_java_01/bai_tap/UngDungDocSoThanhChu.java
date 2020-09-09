package introduction_to_java_01.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {

    public static void hangChuc(int hangChuc) {
        switch (hangChuc) {
            case 0:
                System.out.print(" linh ");
                break;
            case 1:
                System.out.print(" Muoi ");
                break;
            case 2:
                System.out.print(" Hai Muoi ");
                break;
            case 3:
                System.out.print(" Ba Muoi ");
                break;
            case 4:
                System.out.print(" Bon Muoi ");
                break;
            case 5:
                System.out.print(" Nam Muoi ");
                break;
            case 6:
                System.out.print(" Sau Muoi ");
                break;
            case 7:
                System.out.print(" Bay Muoi ");
                break;
            case 8:
                System.out.print(" Tam Muoi ");
                break;
            case 9:
                System.out.print(" Chin Muoi ");
                break;
        }
    }

    public static void hangTran(int hangTram) {
        switch (hangTram) {
            case 0:
                System.out.print(" Khong Tram ");
                break;
            case 1:
                System.out.print(" Mot Tram ");
                break;
            case 2:
                System.out.print(" Hai Tram ");
                break;
            case 3:
                System.out.print(" Ba Tram ");
                break;
            case 4:
                System.out.print(" Bon Tram ");
                break;
            case 5:
                System.out.print(" Nam Tram ");
                break;
            case 6:
                System.out.print(" Sau Tram ");
                break;
            case 7:
                System.out.print(" Bay Tran ");
                break;
            case 8:
                System.out.print(" Tam Tram ");
                break;
            case 9:
                System.out.print(" Chin Tram ");
                break;
        }
    }
    public static void donVi(int donVi){
        switch (donVi) {
            case 0:
                System.out.print(" Khong ");
                break;
            case 1:
                System.out.print(" Mot ");
                break;
            case 2:
                System.out.print(" Hai ");
                break;
            case 3:
                System.out.print(" Ba ");
                break;
            case 4:
                System.out.print(" Bon ");
                break;
            case 5:
                System.out.print(" Nam ");
                break;
            case 6:
                System.out.print(" Sau ");
                break;
            case 7:
                System.out.print(" Bay ");
                break;
            case 8:
                System.out.print(" Tam ");
                break;
            case 9:
                System.out.print(" Chin ");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào một số:");
        int nhapSo = input.nextInt();
        int donVi = nhapSo % 10;
        int chuc = (nhapSo / 10) % 10;
        int tram = (nhapSo / 100) % 10;
        if (chuc == 0) {
            donVi(donVi);
        } else if (tram == 0) {
            hangChuc(chuc);
            donVi(donVi);
        } else {
            hangTran(tram);
            hangChuc(chuc);
            donVi(donVi);

        }

    }
}