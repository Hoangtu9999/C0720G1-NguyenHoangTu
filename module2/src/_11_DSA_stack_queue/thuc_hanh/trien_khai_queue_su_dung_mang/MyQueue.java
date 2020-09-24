package _11_DSA_stack_queue.thuc_hanh.trien_khai_queue_su_dung_mang;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){ //1
            status = true;
        }
        return status;
    }
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++; //tail = 0
            if (tail == capacity - 1) { // 0 == 4-1
                tail = 0;
            }
            queueArr[tail] = item; //queueArr[0] = 4
            currentSize++; //1
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++; //1
            if (head == capacity - 1) {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
        }
            currentSize--;
        }
    }
}
