import java.util.HashSet;

public class Graph {
    private final int capacity;
    private final HashSet<Node> nodes;

    public Graph(int capacity){
        this.capacity = capacity;
        nodes = new HashSet<>(capacity);
    }

    public Graph(){
        this(10);
    }

    public boolean addNode(String n){
        Node node  = new Node(n);
        if(nodes.contains(node))
            return false;
        nodes.add(node);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;

        Graph graph = (Graph) o;
        if(capacity != graph.capacity) return false;
        return nodes.equals(graph.nodes);
    }

    @Override
    public int hashCode() {
        return nodes.hashCode();
    }
}
