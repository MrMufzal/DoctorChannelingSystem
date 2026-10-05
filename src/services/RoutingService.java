package services;
public class RoutingService {
    private int vertices;
    private int[][] graph;
    private String[] locationNames;
    private static final int INF =
            Integer.MAX_VALUE / 2;
    // Constructor
    public RoutingService(int vertices,
                          String[] locationNames) {
        this.vertices = vertices;
        this.locationNames = locationNames;
        this.graph = new int[vertices][vertices];

        // Initialize all distances to INF
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }
    }
    // Add edge between two locations
    public void addEdge(int source,
                        int destination,
                        int weight) {
        graph[source][destination] = weight;
        graph[destination][source] = weight;
    }

    // Floyd-Warshall Algorithm
    public void floydWarshall() {
        // Copy graph into distance matrix
        int[][] dist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            } }
        // Check every intermediate node k
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != INF &&
                            dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] <
                    dist[i][j]) {

                        dist[i][j] =
                                dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printResult(dist);
    }
    private void printResult(int[][] dist) {
        System.out.println(
                "\nFloyd-Warshall Shortest Paths " +
                        "Between All Locations:"
        );
        System.out.println(
                "─────────────────────────────────"
        );

        // Print header row
        System.out.printf("%-12s", "");
        for (String name : locationNames) {
            System.out.printf("%-12s", name);
        }
        System.out.println();

        // Print each row
        for (int i = 0; i < vertices; i++) {
            System.out.printf(
                    "%-12s", locationNames[i]
            );
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF) {
                    System.out.printf("%-12s", "∞");
                } else {
                    System.out.printf(
                            "%-12d", dist[i][j]
                    );
                }
            }
            System.out.println();
        }
    }
}