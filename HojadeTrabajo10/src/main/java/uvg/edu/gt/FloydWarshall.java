package uvg.edu.gt;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distances;
    private String[][] next;

    public FloydWarshall(Graph graph) {
        int numVertices = graph.getCities().size();
        distances = new int[numVertices][numVertices];
        next = new String[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distances[i][j] = graph.getAdjMatrix()[i][j];
                if (graph.getAdjMatrix()[i][j] != Integer.MAX_VALUE / 2) {
                    next[i][j] = graph.getCities().get(j);
                }
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public int[][] getDistances() {
        return distances;
    }

    public String[][] getNext() {
        return next;
    }

    public String getPath(String city1, String city2, Graph graph) {
        int index1 = graph.getCities().indexOf(city1);
        int index2 = graph.getCities().indexOf(city2);
        if (next[index1][index2] == null) {
            return "No path";
        }
        List<String> path = new ArrayList<>();
        path.add(city1);
        while (!city1.equals(city2)) {
            city1 = next[index1][index2];
            path.add(city1);
            index1 = graph.getCities().indexOf(city1);
        }
        return String.join(" -> ", path);
    }
}
