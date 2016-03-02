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
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Edge)) return false;
        Edge other = (Edge) obj;
        return from.isSimilar(other.from) && to.isSimilar(other.to);
    }

    public boolean isHeavier(Edge e){
        return this.weight.isHeavierThan(e.weight);
    }
}
