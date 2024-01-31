class CLL {
    Node head = null;
    Node tail = null;

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
        }
    }

    public void display() {
        Node p = head;
        do {
            System.out.print(p.data + "->");
            p = p.next;
        } while (p != head);
    }

    public void Insert(int val) {
        Node x = new Node(val);
        if (head == null) {
            head = tail = x;
            return;
        }
        x.next = head;
        tail.next = x;
        tail = x;
    }
}

public class circular {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.Insert(1);
        list.Insert(2);
        list.Insert(3);
        list.Insert(4);
        list.display();
    }
}

// 2
import java.util.*;

class Main {
    static Node head;
    static Node tail;

    static class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    public static void display() {
        Node p = head;
        do {
            System.out.print(p.data + "->");
            p = p.next;
        } while (p != head);
    }

    static void Insert(int x) {
        Node p = new Node(x);
        if (tail == null) {
            tail = head = p;
            p.next = tail;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }
    }

    public static void main(String[] args) {
        Insert(1);
        Insert(2);
        Insert(3);
        Insert(4);
        Insert(5);
        display();
    }
}