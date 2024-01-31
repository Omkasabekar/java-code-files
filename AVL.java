import java.util.*;

public class AVL {
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
        preorder(p.lchild);
        preorder(p.rchild);
    }

    static int height(Node p) {
        if (p == null) {
            return 0;
        }
        int x, y = 0;
        x = height(p.lchild);
        y = height(p.rchild);
        if (x > y) {
            return x + 1;
        }
        return y + 1;
    }

    static int balancedfactor(Node p) {
        if (p == null) {
            return 0;
        }
        int x, y = 0;
        x = height(p.lchild);
        y = height(p.rchild);
        return x - y;
    }

    static Node LLrotation(Node p) {
        Node pl = p.lchild;
        p.lchild = pl.rchild;
        pl.rchild = p;
        if (root == p) {
            root = pl;
        }
        return pl;
    }

    static Node LRrotation(Node p) {
        Node pl = p.lchild;
        Node plr = pl.rchild;
        pl.rchild = plr.lchild;
        p.lchild = plr.rchild;
        plr.lchild = pl;
        plr.rchild = p;
        if (root == p) {
            root = plr;
        }
        return plr;
    }

    static Node RRrotation(Node p) {
        Node pr = p.rchild;
        p.rchild = pr.lchild;
        pr.lchild = p;
        if (root == p) {
            root = pr;
        }
        return pr;
    }

    static Node RLrotation(Node p) {
        Node pr = p.rchild;
        Node prl = pr.lchild;
        pr.lchild = prl.rchild;
        p.rchild = prl.lchild;
        prl.rchild = pr;
        prl.lchild = p;
        if (root == p) {
            root = prl;
        }
        return prl;
    }

    // insert

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

        if (balancedfactor(p) == 2 && balancedfactor(p.lchild) == 1) {
            return LLrotation(p);
        } else if (balancedfactor(p) == 2 && balancedfactor(p.lchild) == -1) {
            return LRrotation(p);
        } else if (balancedfactor(p) == -2 && balancedfactor(p.rchild) == -1) {
            return RRrotation(p);
        } else if (balancedfactor(p) == -2 && balancedfactor(p.rchild) == 1) {
            return RLrotation(p);
        }

        return p;
    }

    // detete

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

        if (balancedfactor(p) == 2 && balancedfactor(p.lchild) == 1) {
            return LLrotation(p);
        } else if (balancedfactor(p) == 2 && balancedfactor(p.lchild) == -1) {
            return LRrotation(p);
        } else if (balancedfactor(p) == 2 && balancedfactor(p.lchild) == 0) {
            return LLrotation(p);
        } else if (balancedfactor(p) == -2 && balancedfactor(p.rchild) == -1) {
            return RRrotation(p);
        } else if (balancedfactor(p) == -2 && balancedfactor(p.rchild) == 1) {
            return RLrotation(p);
        } else if (balancedfactor(p) == -2 && balancedfactor(p.rchild) == 0) {
            return RRrotation(p);
        }
        return p;
    }

    public static void main(String[] args) {
        AVL a = new AVL();
        int arr[] = { 10, 20, 25, 28, 30, 8, 5 };
        for (int i = 0; i < arr.length; i++) {
            a.root = insert(root, arr[i]);
        }
        a.inorder(root);
        a.Delete(root, 30);
        System.out.println();
        a.inorder(root);
        System.out.println();
        a.preorder(root);
    }
}
