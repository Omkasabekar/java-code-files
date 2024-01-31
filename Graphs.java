import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graphs {
    static class Edge {
        int src;
        int desc;

        Edge(int s, int d) {
            this.src = s;
            this.desc = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void BFS(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (vis[cur] == false) {
                System.out.print(cur + " ");
                vis[cur] = true;

                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    q.add(e.desc);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int cur, boolean vis[]) {
        System.out.print(cur + " ");
        vis[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (vis[e.desc] == false)
                DFS(graph, e.desc, vis);
        }
    }

    public static void main(String[] args) {
        int V = 7;
        boolean vis[] = new boolean[V];
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        BFS(graph, V);
        DFS(graph, 0, vis);
    }
}