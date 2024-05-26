package uvg.edu.gt;

public class GraphCenter {
    public static String getCenter(Graph graph, FloydWarshall floydWarshall) {
        int[][] distances = floydWarshall.getDistances();
        int numVertices = graph.getCities().size();
        int minMaxDistance = Integer.MAX_VALUE;
        String center = null;

        for (int i = 0; i < numVertices; i++) {
            int maxDistance = 0;
            for (int j = 0; j < numVertices; j++) {
                if (i != j && distances[i][j] > maxDistance) {
                    maxDistance = distances[i][j];
                }
            }
            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance;
                center = graph.getCities().get(i);
            }
        }
        return center;
    }
}

