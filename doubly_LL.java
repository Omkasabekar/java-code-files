import java.util.*;

class DLL {
    Node head;
    int size;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int x) {
            this.data = x;
        }
    }

    void Display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.print("end");
    }

    void displayrev() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.prev;
        }
        System.out.print("end");
    }

    void Insertfirst(int val) {
        Node y = new Node(val);
        y.next = head;
        y.prev = null;
        if (head != null) {
            head.prev = y;
        }
        head = y;
    }

    void Insert(int val, int pos) {
        Node y = new Node(val);
        y.next = null;
        y.prev = null;
        Node p = head;
        if (head == null) {
            Insertfirst(val);
            return;
        }
        if (pos == 0) {
            y.next = head;
            head.prev = y;
            head = y;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                p = p.next;
            }
            y.next = p.next;
            y.prev = p;
            if (p.next != null) {
                p.next.prev = y;
            }
            p.next = y;
        }
    }

    // use to insert after a particular number.
    public Node find(int val) {
        Node p = head;
        while (p != null) {
            if (p.data == val) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void insertafter(int after, int val) {
        Node p = find(after);
        if (p == null) {
            System.out.println("does not exit");
            return;
        }
        Node q = new Node(val);
        q.next = p.next;
        q.prev = p;
        if (p.next != null) {
            p.next.prev = q;
        }
        p.next = q;

    }

    void Insertlast(int val) {
        Node y = new Node(val);
        y.next = null;
        y.prev = null;
        if (head == null) {
            head = y;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = y;
        y.prev = last;
    }
}

class doubly_LL {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.Insertfirst(1);
        list.Insertfirst(2);
        list.Insertfirst(3);
        list.Insertfirst(4);
        list.Insert(7, 1);
        list.Insertlast(8);
        list.insertafter(3, 9);
        list.Display();
    }
}