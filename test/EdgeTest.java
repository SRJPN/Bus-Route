import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class EdgeTest {

    @Test
    public void testHasNode_return_true_if_edge_has_the_node_at_any_ends() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Edge edge = new Edge(node, another);
        assertTrue(edge.hasNode(node));
        assertTrue(edge.hasNode(another));
    }

    @Test
    public void testHasNode_return_false_if_the_node_not_a_part_of_the_edge() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Node yetAnother = new Node("done");
        Edge edge = new Edge(node, another);
        assertFalse(edge.hasNode(yetAnother));
    }

    @Test
    public void testEquals_returns_true_if_the_edges_are_same() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Edge edge = new Edge(node, another);
        Edge anotherEdge = new Edge(node, another);
        assertTrue(edge.equals(edge));
        assertTrue(edge.equals(anotherEdge));
    }

    @Test
    public void testEquals_returns_false_if_the_edges_are_not_same() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Node yetAnother = new Node("done");
        Edge edge = new Edge(node, another);
        Edge anotherEdge = new Edge(node, yetAnother);
        Edge yetAnotherEdge = new Edge(another, node);
        assertFalse(edge.equals(anotherEdge));
        assertFalse(edge.equals(yetAnotherEdge));
    }

    @Test
    public void testisHeavier_returns_true_for_the_heavier_weight() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Node yetAnother = new Node("done");
        Edge edge = new Edge(node, another,new Weight(4));
        Edge anotherEdge = new Edge(node, yetAnother, new Weight(2));
        assertTrue(edge.isHeavier(anotherEdge));
    }

    @Test
    public void testisHeavier_returns_false_for_the_lighter_weight() throws Exception {
        Node node = new Node("node");
        Node another = new Node("edon");
        Node yetAnother = new Node("done");
        Edge edge = new Edge(node, another,new Weight(2));
        Edge anotherEdge = new Edge(node, yetAnother, new Weight(4));
        assertFalse(edge.isHeavier(anotherEdge));
    }
}