import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GraphTest {

    @Test
    public void testAddNode_returns_true_for_added_node() throws Exception {
        Graph graph = new Graph();
        assertTrue(graph.addNode("node"));
    }

    @Test
    public void testAddNode_wont_add_a_previously_added_node() throws Exception {
        Graph graph = new Graph();
        graph.addNode("node");
        assertFalse(graph.addNode("node"));
    }

    @Test
    public void testEquals_returns_true_for_similar_graph() throws Exception {
        Graph graph = new Graph(15);
        Graph another = new Graph(15);
        assertTrue(graph.equals(another));
    }

    @Test
    public void testEquals_returns_false_for_graphs_with_different_capacity() throws Exception {
        Graph graph = new Graph(10);
        Graph another = new Graph(15);
        assertFalse(graph.equals(another));
    }

    @Test
    public void testEquals_returns_false_for_different_graph() throws Exception {
        Graph graph = new Graph();
        graph.addNode("node");
        Graph another = new Graph();
        assertFalse(graph.equals(another));
    }

    @Test
    public void testHashCode_gives_same_hashCode_for_similar_Graphs() throws Exception {
        Graph graph = new Graph(10);
        Graph another = new Graph(15);
        assertEquals(graph.hashCode(), another.hashCode());
    }

    @Test
    public void testAddEdgeTo_returns_true_and_adds_edge_to_node_present_in_graph() throws Exception {
        Graph graph = new Graph(10);
        graph.addNode("node");
        graph.addNode("edon");
        Weight weight = new Weight(1);
        assertTrue(graph.addEdgeBetween("node", "edon", weight));
    }

    @Test
    public void testAddEdgeTo_creates_a_new_edge_with_default_weight_if_weight_is_not_given() throws Exception {
        Graph graph = new Graph(10);
        graph.addNode("node");
        graph.addNode("edon");
        assertTrue(graph.addEdgeBetween("node", "edon"));
    }

    @Test
    public void testAddEdgeTo_returns_false_if_it_couldnt_find_nodes_in_the_graph() throws Exception {
        Graph graph = new Graph(10);
        graph.addNode("node");
        Weight weight = new Weight(1);
        assertFalse(graph.addEdgeBetween("node", "edon", weight));
    }

    @Test
    public void testIsThereEdgeBetween_returns_true_if_there_is_a_real_edge_between_both_nodes() throws Exception {
        Graph graph = new Graph(10);
        graph.addNode("node");
        graph.addNode("edon");
        graph.addEdgeBetween("node", "edon");

        assertTrue(graph.isThereEdgeBetween("node","edon"));
    }

    @Test
    public void testIsThereEdgeBetween_returns_false_if_there_is_no_real_edge_between_both_nodes() throws Exception {
        Graph graph = new Graph(10);
        graph.addNode("node");
        graph.addNode("edon");

        assertFalse(graph.isThereEdgeBetween("node","edon"));
    }
}