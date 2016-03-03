import java.util.ArrayList;
import java.util.Iterator;

public class Node {
    String name;
    ArrayList<Edge> edges;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public boolean addEdge(Edge e){
        if(e.hasNode(this)) {
            this.edges.add(e);
            return true;
        }
        return false;
    }

    public boolean isSimilar(Node other){
       return this.name.equals(other.name);
    }

    public boolean hasEdgeWith(Node node){
        for (Edge edge : edges)
            if (edge.hasNode(node))
                return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;
        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + edges.hashCode();
        return result;
    }

    public Iterator getAllEdges(){
        return this.edges.iterator();
    }
}
