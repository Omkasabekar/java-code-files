import java.util.*;
//by using array
/* 
public class Queue {
    public static class innerqueue {
        int front = -1;
        int rear = -1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        void enqueue(int x) {
            if (rear == n - 1) {
                System.out.println("overflow");
            } else {
                rear++;
                arr[rear] = x;
            }
        }

        void dequeue() {
            if (front == rear) {
                System.out.println("underflow");
            } else {
                front++;
                System.out.println(arr[front]);
            }
        }

        void display() {
            for (int i = front + 1; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        innerqueue q = new innerqueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.display();
    }
}
*/

// by using circular array
/* 
class Queue{
    public static class innerqueue {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        int front=0;
        int rear=0;

        void display(){
            int i=front+1;
            do{
                System.out.println(arr[i]);
                i=(i+1)%size;
            }while(i!=(rear+1)%size);
        }

        void enqueue(int x){
            if((rear+1)%size==front){
                System.out.println("queue is full");
            }
            else{
                rear=(rear+1)%size;
                arr[rear]=x;
            }
        }

       int dequeue(){
            int x=-1;
            if(front==rear){
                System.out.println("queue is empty");
            }
            else{
                front=(front+1)%size;
                x=arr[front];
            }
            return x;
        }
        
    }
    public static void main(String[] args) {
        innerqueue q=new innerqueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.display();
    }
}
*/

//by using linklist 

class Queue {
    public static class innerqueue {
        Node front = null;
        Node rear = null;

        class Node {
            int data;
            Node next;
        }

        void enqueue(int x) {
            Node t = new Node();
            t.data = x;
            t.next = null;
            if (t == null) {
                System.out.println("overflow");
            } else if (front == null) {
                front = rear = t;
            } else {
                rear.next = t;
                rear = t;
            }
        }

        void dequeue() {
            if (front == null) {
                System.out.println("underflow");
            } else {
                System.out.println(front.data);
                front = front.next;
            }
        }

        void display() {
            Node p = front;
            while (p != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        innerqueue q = new innerqueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.display();
    }
}
