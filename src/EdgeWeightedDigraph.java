import java.util.LinkedList;

public class EdgeWeightedDigraph {
    // number of vertex
    private final int V;

    // adj list
    private final LinkedList<DirectedEdge>[] adj;

    // constructor
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<DirectedEdge>();
    }

    //--------------------------------------------------------
    // Summary: Connecting the vertex with the vertices.
    // Precondition: e is Edge
    // Postcondition: vertices connected by edges.
    //--------------------------------------------------------
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    //return adj list
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    // return number of vertex
    public int V() {
        return V;
    }
}