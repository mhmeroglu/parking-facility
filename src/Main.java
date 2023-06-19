import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int N = scanner.nextInt(); // Number of nodes
        int M = scanner.nextInt(); // Number of edges
        int F = scanner.nextInt(); // Parking fee

        // Read seating capacities of parking slots
        int[] capacities = new int[N];
        for (int i = 0; i < N; i++) {
            capacities[i] = scanner.nextInt();
        }

        // Create an edge-weighted digraph
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(N);

        // Read the edges and their weights
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1; // Convert to 0-based indexing
            int v = scanner.nextInt() - 1; // Convert to 0-based indexing
            int w = scanner.nextInt();
            DirectedEdge edge = new DirectedEdge(u, v, w);
            graph.addEdge(edge);
        }

        // Read the number of vehicles entering the parking facility
        int K = scanner.nextInt();
        int[] vehicleCosts = new int[K];
        Arrays.fill(vehicleCosts, -1);

        // Track the usage of parking slots
        int[] slotUsage = new int[N];

        // Process each vehicle entering the facility
        for (int i = 0; i < K; i++) {
            DijkstraSP dijkstra = new DijkstraSP(graph, 0); // Run Dijkstra's algorithm from the source vertex (0)
            int minCost = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the parking slot with the minimum cost and available capacity
            for (int j = 0; j < N; j++) {
                int cost = (int) (dijkstra.distTo[j] + F); // Calculate the cost for parking in slot j
                if (capacities[j] > 0 && cost < minCost && slotUsage[j] < capacities[j]) {
                    minCost = cost;
                    minIndex = j;
                }
            }

            // If a suitable parking slot is found, assign it to the vehicle and update the slot usage
            if (minIndex != -1) {
                vehicleCosts[i] = minCost;
                slotUsage[minIndex]++;
            }
        }

        // Print the costs for each vehicle entering the facility
        for (int cost : vehicleCosts) {
            System.out.print(cost + " ");
        }
    }
}