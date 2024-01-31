import java.util.*;

public class BST {
    static Node root = null;

    static class Node {
        int data;
        Node lchild;
        Node rchild;

        Node(int x) {
            this.data = x;
            this.lchild = null;
            this.rchild = null;
        }

    }

    static void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.lchild);
        System.out.print(p.data + " ");
        inorder(p.rchild);
    }

    static void preorder(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + " ");
        inorder(p.lchild);
        inorder(p.rchild);
    }

    static Node insert(Node p, int key) {
        Node t = new Node(key);
        if (p == null) {
            return t;
        }
        if (key < p.data) {
            p.lchild = insert(p.lchild, key);
        } else if (key > p.data) {
            p.rchild = insert(p.rchild, key);
        }
        return p;
    }

    static int search(Node p, int key) {
        if (p == null) {
            return 0;
        }
        if (key < p.data) {
            return search(p.lchild, key);
        } else if (key > p.data) {
            return search(p.rchild, key);
        } else {
            return p.data;
        }
        // return 0;
    }

    static Node inpre(Node p) {
        while (p != null && p.rchild != null) {
            p = p.rchild;
        }
        return p;
    }

    static Node insucc(Node p) {
        while (p != null && p.lchild != null) {
            p = p.lchild;
        }
        return p;
    }

    static int height(Node p) {
        if (p == null) {
            return 0;
        }
        int x = height(p.lchild);
        int y = height(p.rchild);
        if (x > y) {
            return x + 1;
        } else {
            return y + 1;
        }
    }

    static Node Delete(Node p, int key) {
        Node t = new Node(key);
        Node q = null;
        if (p == null) {
            return null;
        }
        if (p.lchild == null && p.rchild == null) {
            if (p == root) {
                root = null;
            }
            return null;
        }
        if (key < p.data) {
            p.lchild = Delete(p.lchild, key);
        } else if (key > p.data) {
            p.rchild = Delete(p.rchild, key);
        } else {
            if (height(p.lchild) > height(p.rchild)) {
                q = inpre(p.lchild);
                p.data = q.data;
                p.lchild = Delete(p.lchild, q.data);
            } else {
                q = insucc(p.rchild);
                p.data = q.data;
                p.rchild = Delete(p.rchild, q.data);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        BST b = new BST();
        int[] arr = { 10, 8, 7, 5, 15, 50, 56, 45, 12, 1, 6, 4, 8, 96 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        preorder(root);
        Delete(root, 56);
        Delete(root, 5);
        System.out.println();
        inorder(root);
    }
}
