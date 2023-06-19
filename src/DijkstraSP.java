public class DijkstraSP
{
    DirectedEdge[] edgeTo; // edgeTo diedge array
    double[] distTo; // disTo array
    private IndexMinPQ<Double> pq;  // indexminpq

    // constructor
    public DijkstraSP(EdgeWeightedDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }
    }

    // Summary: Updates the distance to vertex w if a shorter path is found through vertex v.
    // Precondition: distTo[] and edgeTo[] are initialized. e is a directed edge connecting vertex v to vertex w.
    // Postcondition: Updates the distance to vertex w and the corresponding edgeTo[] entry if a shorter path is found.
    // Decreases the key (distance) of vertex w if it is already in the priority queue.
    // Inserts vertex w into the priority queue with its updated key if it is not already present.
    private void relax(DirectedEdge e)
    {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight())
        {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert (w, distTo[w]);
        }
    }
}