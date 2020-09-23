package _11_DSA_stack_queue.bai_tap.dao_nguoc_phtu_trong_mang_so_nguyen_su_dung_stack;

import java.util.Stack;

public class ReverseStackString {
    public static void main(String[] args) {
        String mWork = "nguyen hoang tu";
        Stack<Character> listStack = new Stack<>();


        for (Character i = 0; i < mWork.length(); i++) {
            listStack.push(mWork.charAt(i));
        }
        for (int i = 0; i < mWork.length(); i++) {
            System.out.print(listStack.pop());
        }
    }
}