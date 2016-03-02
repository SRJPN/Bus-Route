public class Edge {
    private final Node from, to;
    private final Weight weight;

    public Edge(Node from, Node to, Weight weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Edge(Node from, Node to) {
        this(from, to, new Weight(1));
    }

    public boolean hasNode(Node node) {
        return this.from.isSimilar(node) || this.to.isSimilar(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (!from.equals(edge.from)) return false;
        if (!to.equals(edge.to)) return false;
        return weight.equals(edge.weight);

    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }

    public boolean isHeavier(Edge e){
        return this.weight.isHeavierThan(e.weight);
    }
}
