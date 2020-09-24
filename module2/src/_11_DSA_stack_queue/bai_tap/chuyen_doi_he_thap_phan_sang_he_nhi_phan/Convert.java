package _11_DSA_stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_he_nhi_phan;

import java.util.Stack;

public class Convert {
    public static int convertBinary(int num) {
        Stack<Integer> stack = new Stack<Integer>();

        while (num != 0) {

            int d = num % 2;

            stack.push(d);

            num /= 2;
        }

        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());

        }
        return num;
    }

    public static int binaryIntoDecimal(int[] number) {
        int temp = 0;
        int sum = 0;
        for (int i = number.length - 1; i >= 0; i--) {

            sum += (int) (number[i] * Math.pow(2, temp));
            temp++;
        }
        return sum;
    }
}
