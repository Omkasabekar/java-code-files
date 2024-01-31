class SLL {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
    }

    void insertfirst(int val) {
        Node x = new Node(val);
        x.next = head;
        head = x;
        if (tail == null) {
            tail = head;
        }
    }

    void insert(int pos, int val) {
        if (pos == 0) {
            insertfirst(val);
            return;
        }
        Node p = head;
        Node x = new Node(val);
        for (int i = 0; i < pos - 1; i++) {
            p = p.next;
        }
        x.next = p.next;
        p.next = x;
    }

    void insertlast(int val) {
        Node x = new Node(val);
        tail.next = x;
        tail = x;
    }

    int count() {
        Node p = head;
        int total = 0;
        while (p != null) {
            total++;
            p = p.next;
        }
        return total;
    }

    int find(int val) {
        Node p = head;
        while (p != null) {
            if (p.data == val) {
                return 1;
            }
            p = p.next;
        }
        return 0;
    }

    void deletefirst() {
        if (head != null) {
            head = head.next;
        }
    }

    void delete(int pos) {
        Node p = head;
        Node q = null;
        for (int i = 0; i < pos - 1; i++) {
            q = p;
            p = p.next;
        }
        q.next = p.next;
    }

    void deletelast() {
        Node p = head;
        if (tail != null) {
            while (p.next != tail) {
                p = p.next;
            }
        }
        p.next = null;
        tail = p;
    }
}

public class lab2 {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertfirst(1);
        list.insertfirst(2);
        list.insertfirst(3);
        list.insertfirst(4);
        list.insert(0, 7);
        list.insertlast(9);
        //list.insert(3, 0);
        list.display();
        System.out.println();
        list.delete(2);
        list.display();
    }
}
