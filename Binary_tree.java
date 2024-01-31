import java.util.*;

import BST.Node;

class Binary_tree {
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

    public static class innerqueue {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Node arr[] = new Node[size];
        int front = 0;
        int rear = 0;

        void enqueue(Node x) {
            if ((rear + 1) % size == front) {
                System.out.println("queue is full");
            } else {
                rear = (rear + 1) % size;
                arr[rear] = x;
            }
        }

        Node dequeue() {
            Node x = null;
            if (front == rear) {
                System.out.println("queue is empty");
            } else {
                front = (front + 1) % size;
                x = arr[front];
            }
            return x;
        }

        int isempty() {
            if (front == rear) {
                return 1;
            }
            return 0;
        }

    }

    static void createtree() {
        Node p = null;
        Node t = null;
        innerqueue inq = new innerqueue();
        int x;
        System.out.print("enter the root value:");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        root = new Node(x);
        inq.enqueue(root);
        while (inq.isempty() == 0) {
            p = inq.dequeue();
            System.out.print("enter the left child of " + p.data + " :");
            x = sc.nextInt();
            if (x != -1) {
                t = new Node(x);
                p.lchild = t;
                inq.enqueue(t);
            }
            System.out.print("enter the right child of " + p.data + " :");
            x = sc.nextInt();
            if (x != -1) {
                t = new Node(x);
                p.rchild = t;
                inq.enqueue(t);
            }
        }
    }

    static void display(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + " ");
        display(p.lchild);
        display(p.rchild);
    }

    public static void main(String[] args) {
        Binary_tree m = new Binary_tree();
        m.createtree();
        m.display(root);
    }
}

// itterative version
static class innerstack {
    Scanner sc = new Scanner(System.in);
    // int size=sc.nextInt();
    Node arr[] = new Node[10];
    int top = -1;

    void push(Node x) {
        if (top == 10 - 1) {
            System.out.println("stack is overflow");
        } else {
            top++;
            arr[top] = x;
        }
    }

    Node pop() {
        Node x = null;
        if (top == -1) {
            System.out.println("stack is underflow");
        } else {
            x = arr[top];
            top--;
        }
        return x;
    }

    int empty() {
        if (top == -1) {
            return 1;
        }
        return 0;
    }

}

    static void preorder(Node p) {
        innerstack s = new innerstack();
        while (p != null || s.empty() != 1) {
            if (p != null) {
                System.out.print(p.data + " ");
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                p = p.right;
            }

        }
    }

    static void inorder(Node p) {
        innerstack s = new innerstack();
        while (p != null || s.empty() != 1) {
            if (p != null) {
                s.push(p);
                p = p.lchild;
            } else {
                p = s.pop();
                System.out.print(p.data + " ");
                p = p.rchild;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.createtree();
        m.preorder(root);
    }

    // levelorder
static void levelorder(Node p){
    innerqueue q=new innerqueue();
    //Node p=null;
    System.out.print(p.data+" ");
    q.enqueue(p);
    while(q.isempty()!=1){
        p=q.dequeue();
        if(p.left!=null){
            System.out.print(p.left.data+" ");
            q.enqueue(p.left);
            
        }
        if(p.right!=null){
            System.out.print(p.right.data+" ");
            q.enqueue(p.right);
            
        }
    }
}