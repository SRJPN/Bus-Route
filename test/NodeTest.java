import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NodeTest {

    @Test
    public void testisSimilar_tells_true_if_both_nodes_are_similar() throws Exception {
        Node node = new Node("node");
        Node another = new Node("node");
        assertTrue(node.isSimilar(another));
    }

    @Test
    public void testisSimilar_tells_false_if_both_nodes_are_not_similar() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        assertFalse(node.isSimilar(another));
    }

    @Test
    public void testAddEdge_addes_edge_to_the_node_only_if_it_is_its_edge() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Edge edge = new Edge(node, another);
        assertTrue(node.addEdge(edge));
    }

    @Test
    public void testAddEdge_never_addes_another_edge_which_the_node_is_not_a_part_of() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Node yetAnother = new Node("done");
        Edge edge = new Edge(another, yetAnother);
        assertFalse(node.addEdge(edge));
    }

    @Test
    public void testGetAllEdges_gives_an_itratror_with_all_the_edges() throws Exception {
        Node node = new Node("Node");
        Node another = new Node("edon");
        Edge edge = new Edge(node, another);
        Edge anotherEdge = new Edge(another, node);

        Edge[] expectedEdges = {edge, anotherEdge};

        Iterator edges = node.getAllEdges();
        int count = 0;
        while (edges.hasNext()){
            assertEquals(expectedEdges[count],edges.next());
            count++;
        }
    }

    @Test
    public void testhashCode_gives_hashCode_according_to_the_contents() throws Exception {
        Node node = new Node("Node");
        assertEquals(75440671,node.hashCode());
    }

    @Test
    public void testhashCode_will_be_same_for_object_with_same_content() throws Exception {
        Node node = new Node("Node");
        Node another = new Node("Node");
        assertEquals(node.hashCode(),another.hashCode());
    }
}