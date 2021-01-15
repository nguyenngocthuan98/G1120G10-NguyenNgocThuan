package bai10_dsa_list.thuc_hanh.simple_linkedlist;

public class LinkedList {
    //numNodes size xác định số phần tử trong danh sách, mặc định gán là 0.
    private int numNodes;

    //Lớp MyLinkedList chứa lớp Node.
    private class Node {
        private Node next;
        private Object data;

        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        @Override
        public String toString() {
            return "data = " + data + ", next = " + next;
        }
    }

    //head đối tượng lớp Node
    private Node head;

    //Phương thức khởi tạo một tham số khởi tạo node đầu tiên trong danh sách
    public LinkedList(Object data) {
        head = new Node(data);
    }

    //Thêm đối tượng vào vị trí thứ index trong danh sách
    public void add(int index, Object data) {
        Node temp = head; // cho temp = node head (node đầu tiên)

        // Vòng for chạy từ đầu list cho đến vị trí index-1, mục đích cho temp đến vị trí index-1
        // kèm điều kiện temp.next != null để bảo đảm rằng temp không phải là vị trí cuối cùng (chiều dài của list này là 1)
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder = temp.next; // tạo holder = temp.next (holder nằm ở vị trí index hiện tại)
        temp.next = new Node(data); // 1 node mới có next của temp trỏ đến
        temp.next.next = holder; // tương đương với next của node mới trỏ đến holder
        numNodes++; // tăng chiều dài của linked list.
    }

    //Thêm đối tượng vào vị trí thứ đầu tiên trong danh sách
    public void addFirst(Object data) {
        Node temp = head; // cho temp = node head (node đầu tiên)
        head = new Node(data); // tạo 1 node mới = head
        head.next = temp; // tương đương với next của node mới trỏ đến temp.
        numNodes++; // tăng chiều dài của linked list.
    }

    //Cài đặt phương thức get(), lấy phần tử ở vị trí index từ danh sách
    public Node getIndex(int index) {
        Node temp = head;// cho temp = node head (node đầu tiên)
        // for chạy đến vị trí index-1, mục đích cho temp.next trỏ đến vị trí của index
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Cài đặt phương thức printList, hiển thị danh sách các phần tử trong danh sách
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp + ", ");
            temp = temp.next;
        }
    }
}
