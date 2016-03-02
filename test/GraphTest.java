import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by soorajp on 02/03/16.
 */
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
}