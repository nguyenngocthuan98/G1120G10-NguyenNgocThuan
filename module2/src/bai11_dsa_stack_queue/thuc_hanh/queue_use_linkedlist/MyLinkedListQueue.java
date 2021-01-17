package bai11_dsa_stack_queue.thuc_hanh.queue_use_linkedlist;

//    Bước 2: Tạo lớp MyLinkedListQueue
public class MyLinkedListQueue {
    public Node head;
    public Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    //    Bước 3: Cài đặt phương thức enqueue trong lớp MyLinkedListQueue
    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    //    Bước 4: Cài đặt phương thức dequeue trong lớp MyLinkedListQueue
    public Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }

    //    main để thực thi ứng dụng
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}

