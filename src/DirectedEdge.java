public class DirectedEdge {

    // vertices
    private final int v, w;

    // weight
    private final double weight;

    // constructor
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // return v value
    public int from() {
        return v;
    }

    // return w value
    public int to() {
        return w;
    }

    // return weight
    public double weight() {
        return weight;
    }
}