package _11_DSA_stack_queue.bai_tap.dao_nguoc_phtu_trong_mang_so_nguyen_su_dung_stack;

import java.util.List;
import java.util.Stack;

public class ReverseStackNumber {
    public static void main(String[] args) {
        Stack<Integer> listStack = new Stack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);


        while (!listStack.isEmpty()){
            System.out.println(listStack.pop());

        }
    }
}
