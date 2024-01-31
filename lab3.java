import java.util.Scanner;

public class lab3 {
    public static class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    static Node head = null;

    static void insert(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = p;
    }

    static void reverse(Node q, Node p) {
        if (p != null) {
            reverse(p, p.next);
            p.next = q;
        } else {
            head = q;
        }
    }

    static void display(Node p) {
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        lab3 l = new lab3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            l.insert(i);
        }
        l.reverse(null, head);
        l.display(head);
    }
}
