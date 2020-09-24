package _11_DSA_stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_he_nhi_phan;

import java.util.Stack;

import static _11_DSA_stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_he_nhi_phan.Convert.binaryIntoDecimal;
import static _11_DSA_stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_he_nhi_phan.Convert.convertBinary;

public class ConverterBinary {

    public static void main(String[] args) {

        int decimalNumber = 1234;
        System.out.print("Hệ nhị phân của " + decimalNumber + " là :");
        convertBinary(decimalNumber);
        System.out.println();
        int[] number = {1,0,0,1,1,0,1,0,0,1,0};
        int test = binaryIntoDecimal(number);
        System.out.println(test);

    }
}