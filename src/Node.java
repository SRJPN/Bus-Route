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

    public Iterator getAllEdges(){
        return this.edges.iterator();
    }
}
