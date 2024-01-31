
// size is optional if we dont write then also it works
// this all the things are done in classes.
import java.util.*;
/* 
class llist {
    Node head;
    Node tail;
    int size;

    llist() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    public void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + "->");
            t = t.next;
        }
        System.out.print("end");
    }

    public void insertfirst(int y) {
        Node x = new Node(y);
        x.next = head;
        head = x;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insert(int y, int pos) {
        Node x = new Node(y);
        if (head == null) {
            insertfirst(y);
            return;
        }
        if (pos == 0) {
            x.next = head;
            head = x;
            return;
        }

        Node p = head;
        for (int i = 0; i < pos - 1; i++) {

            p = p.next;
        }
        x.next = p.next;
        p.next = x;
        size++;
    }

    public void insertlast(int val) {
        Node x = new Node(val);
        if (head == null) {
            insertfirst(val);
            return;
        }
        tail.next = x;
        tail = x;
        size++;
    }

    public int delete(int pos) {
        int x = 0;
        if (pos == 1) {
            x = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return x;
        }
        Node p = head;
        Node q = null;
        for (int i = 0; i < pos - 1; i++) {
            q = p;
            p = p.next;
        }
        x = p.data;
        q.next = p.next;
        return x;
    }
}

class link_list {
    public static void main(String[] args) {
        llist list = new llist();
        list.insertfirst(1);
        list.insertfirst(2);
        list.insertfirst(3);
        list.insertlast(7);
        list.insert(8, 0);
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}*/

// 2 method
import java.util.*;

class link_list {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    static void display(Node p) {
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
    }

    static void create(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            return;
        }
        Node t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = p;
    }

    static void insert(Node p, int x, int index) {
        Node t = new Node(x);
        if (index == 1) {
            t.next = head;
            head = t;
        } else {
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            t.next = p.next;
            p.next = t;
        }
    }

    static void delete(Node p, int index) {
        Node q = null;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                q = p;
                p = p.next;
            }
            q.next = p.next;
        }
    }

    static void reverse(Node q, Node p) {
        if (p != null) {
            reverse(p, p.next);
            p.next = q;
        } else {
            head = q;
        }
    }

    static void reverse1(Node p) {
        Node r = null;
        Node q = null;
        while (p != null) {
            r = q;
            q = p;

            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            create(i);
        }
        insert(head, 7, 3);
        display(head);
        reverse1(head);
        System.out.println();
        display(head);
    }

}