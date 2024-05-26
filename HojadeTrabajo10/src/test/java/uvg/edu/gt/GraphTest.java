package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    public void testAddEdge() {
        Graph graph = new Graph(5);
        graph.addCity("A");
        graph.addCity("B");
        graph.addEdge("A", "B", 10);
        assertEquals(10, graph.getAdjMatrix()[graph.getCities().indexOf("A")][graph.getCities().indexOf("B")]);
    }

    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph(5);
        graph.addCity("A");
        graph.addCity("B");
        graph.addEdge("A", "B", 10);
        graph.removeEdge("A", "B");
        assertEquals(Integer.MAX_VALUE / 2, graph.getAdjMatrix()[graph.getCities().indexOf("A")][graph.getCities().indexOf("B")]);
    }

    @Test
    public void testFloydWarshall() {
        Graph graph = new Graph(5);
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addEdge("A", "B", 10);
        graph.addEdge("B", "C", 5);
        FloydWarshall floydWarshall = new FloydWarshall(graph);
        assertEquals(15, floydWarshall.getDistances()[graph.getCities().indexOf("A")][graph.getCities().indexOf("C")]);
    }
}
