import java.util.*;

public class FloydWarshall {
    private int dist[][];
    private int vertex;
    private int inf = Integer.MAX_VALUE;

    public FloydWarshall(int v) {
        vertex = v;
        dist = new int[vertex+1][vertex+1];

        for(int i = 1; i <= vertex; i++) {
            for(int j = 1; j <= vertex; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = inf;
                }
            }
        }
    }

    public void addEdge(int u, int v, int w) {
        dist[u][v] = w;
    }

    public void floydWarshall() {
        for(int k = 1; k <= vertex; k++) {
            for(int i = 1; i <= vertex; i++) {
                for(int j = 1; j <= vertex; j++) {
                    if(dist[i][k] != inf && dist[k][j] != inf && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    public void printDistances() {
        System.out.println("Shortest distances between every pair of vertices (Matrix):");
        for(int i = 1; i <= vertex; i++) {
            for(int j = 1; j <= vertex; j++) {
                if(dist[i][j] == inf) {
                    System.out.print("inf\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = sc.nextInt();
        FloydWarshall fw = new FloydWarshall(vertices);

        System.out.print("Enter the number of edges in the graph: ");
        int edges = sc.nextInt();

        System.out.println("Enter the details of each edge (source node, destination node, weight):");
        for(int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            fw.addEdge(u, v, w);
        }

        fw.floydWarshall();
        fw.printDistances();
    }
}
