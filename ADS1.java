import java.util.Arrays;

public class ADS1 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    static Node inpre(Node p) {
        while (p != null && p.right != null) {
            p = p.right;
        }
        return p;
    }

    static Node insuc(Node p) {
        while (p != null && p.left != null) {
            p = p.right;
        }
        return p;
    }

    public static void main(String[] args) {
        Node v = new Node(2);
        v.left = new Node(3);
        v.right = new Node(1);

        Node p = inpre(v.left);
        Node q = insuc(v.right);

        int arr[] = new int[2];
        if (p.data > q.data) {
            arr[0] = p.data;
            arr[1] = q.data;
        } else {
            arr[0] = q.data;
            arr[1] = p.data;
        }
        System.out.println(Arrays.toString(arr));
    }
}
