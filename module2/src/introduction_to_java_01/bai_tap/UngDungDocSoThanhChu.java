package introduction_to_java_01.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {

    static String read1To10(int number) {
        String str = "";
        switch(number) {
            case 1:
                str = "one";
                break;
            case 2:
                str = "two";
                break;
            case 3:
                str = "three";
                break;
            case 4:
                str = "four";
                break;
            case 5:
                str = "five";
                break;
            case 6:
                str = "six";
                break;
            case 7:
                str = "seven";
                break;
            case 8:
                str = "eight";
                break;
            case 9:
                str = "nine";
                break;
            case 10:
                str = "ten";
                break;
        }
        return str;
    }
    static String read11To19(int number) {
        String str = null;
        switch(number) {
            case 11:
                str = "eleven";
                break;
            case 12:
                str = "twelve";
                break;
            case 13:
                str = "thirteen";
                break;
            case 14:
                str = "forteen";
                break;
            case 15:
                str = "fifteen";
                break;
            case 16:
            case 17:
            case 18:
            case 19:
                int hangDonVi = number % 10;
                str = read1To10(hangDonVi) + "teen";
                break;
        }
        return str;
    }
    static String readNumberTy(int number) {
        String str = null;
        switch (number) {
            case 20:
                str = "twenty";
                break;
            case 30:
                str = "thirty";
                break;
            case 40:
                str = "forty";
                break;
            case 50:
                str = "fifty";
                break;
            case 60:
            case 70:
            case 80:
            case 90:
                int hangChuc = number / 10;
                str = read1To10(hangChuc) + "ty";
                break;
        }
        return str;
    }
    static String hundred(int number) {
        String str = null;
        switch (number) {
            case 200:
                str = "twenty";
                break;
            case 300:
                str = "thirty";
                break;
            case 400:
                str = "forty";
                break;
            case 500:
                str = "fifty";
                break;
            case 600:
            case 700:
            case 800:
            case 900:
                int hangChuc = number / 10;
                str = read1To10(hangChuc) + "ty";
                break;
        }
        return str;
    }
    public static void main(String[] args) {
        // INPUT
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number: ");
        int number = scanner.nextInt();
        //21
        int hangChuc = number / 10;
        String strHangChuc = hangChuc + "0";
        int hangDonVi = number % 10;
        String result = readNumberTy(Integer.parseInt(strHangChuc)) + " " + read1To10(hangDonVi);

        // STEP 5: 3 chu so
        // 100, 200, 300, 400

        // readOneHundred(int number)
        // -> hangTram = number / 100
        // -> read1To10(hangTram) + "one hundred"
        // hangChucVaDonVi = number % 100;
        // read1To99(hangChucVaDonVi);

        // OUTPUT
        System.out.println("Result: " + result);
    }
}