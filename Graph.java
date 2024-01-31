public class Graph {
    static Node front, rear = null;

    static class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    static void enqueue(int x) {
        Node p = new Node(x);
        if (p == null) {
            System.out.println("queue is full");
        } else {
            if (front == null) {
                front = rear = p;
            }
            rear.next = p;
            rear = p;
        }
    }

    static int dequeue() {
        int x = -1;
        if (front == null) {
            System.out.println("queue is empty");
        } else {
            x = front.data;
            front = front.next;
        }
        return x;
    }

    static int isempty() {
        if (front == null) {
            return 1;
        }
        return 0;
    }

    static void BFS(int G[][], int start, int n) {
        int i = start;
        int visited[] = new int[7];
        System.out.print(i + " ");
        visited[i] = 1;
        enqueue(i);
        while (isempty() != 1) {
            i = dequeue();
            for (int j = 1; j < 7; j++) {
                if (G[i][j] == 1 && visited[j] == 0) {
                    System.out.print(j + " ");
                    visited[j] = 1;
                    enqueue(j);
                }
            }
        }
    }

    static void DFS(int G[][], int start, int n) {

        int visited[] = new int[7];
        if (visited[start] == 0) {
            System.out.print(start + " ");
            visited[start] = 1;
            for (int j = 1; j < 7; j++) {
                if (G[start][j] == 1 && visited[j] == 0) {
                    DFS(G, j, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int G[][] = {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1 }
        };
        DFS(G, 2, 7);
    }

}
