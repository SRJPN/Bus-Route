import java.util.HashMap;

public class Graph {
    private final int capacity;
    private final HashMap<String, Node> nodes;

    public Graph(int capacity){
        this.capacity = capacity;
        nodes = new HashMap<>(capacity);
    }

    public Graph(){
        this(10);
    }

    public boolean addNode(String n){
        if(nodes.containsKey(n))
            return false;
        Node node  = new Node(n);
        nodes.put(n, node);
        return true;
    }

    public boolean addEdgeBetween(String from, String to, Weight weight){
        if(nodes.containsKey(from) && nodes.containsKey(to)) {
            Node nodeFrom = nodes.get(from);
            Node nodeTo = nodes.get(to);
            Edge edge = new Edge(nodeFrom, nodeTo, weight);
            nodes.get(from).addEdge(edge);
            return true;
        }
        return false;
    }

    public boolean addEdgeBetween(String from, String to){
        Weight weight = new Weight(1);
        return addEdgeBetween(from, to, weight);
    }

    public boolean isThereEdgeBetween(String from, String to){
        Node node = nodes.get(from);
        Node another = nodes.get(to);
        return node.hasEdgeWith(another);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;

        Graph graph = (Graph) o;
        return capacity == graph.capacity && nodes.equals(graph.nodes);
    }

    @Override
    public int hashCode() {
        return nodes.hashCode();
    }
}
