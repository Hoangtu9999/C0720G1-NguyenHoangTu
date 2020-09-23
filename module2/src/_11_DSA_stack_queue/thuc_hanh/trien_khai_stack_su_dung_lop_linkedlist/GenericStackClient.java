package _11_DSA_stack_queue.thuc_hanh.trien_khai_stack_su_dung_lop_linkedlist;



import static _11_DSA_stack_queue.thuc_hanh.trien_khai_stack_su_dung_lop_linkedlist.MyGenericStack.stackOfIStrings;
import static _11_DSA_stack_queue.thuc_hanh.trien_khai_stack_su_dung_lop_linkedlist.MyGenericStack.stackOfIntegers;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}