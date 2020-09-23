package _11_DSA_stack_queue.bai_tap.trien_khai_queue_su_dung_danh_sach_lien_ket_vong;

import static _11_DSA_stack_queue.bai_tap.trien_khai_queue_su_dung_danh_sach_lien_ket_vong.Solution.*;

public class TestSolution {
    public static void main(String args[]) {
        Queue q = new Queue();
        q.front = q.rear = null;

        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);

        displayQueue(q);

        System.out.printf(" Deleted value = %d", deQueue(q));
        System.out.printf(" Deleted value = %d", deQueue(q));

        displayQueue(q);

        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);

    }
}

