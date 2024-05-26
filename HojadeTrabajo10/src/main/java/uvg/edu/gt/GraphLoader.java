package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphLoader {
    public static Graph loadGraph(String filename, int numVertices) throws IOException {
        Graph graph = new Graph(numVertices);
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String city1 = parts[0];
            String city2 = parts[1];
            int distance = Integer.parseInt(parts[2]);
            graph.addCity(city1);
            graph.addCity(city2);
            graph.addEdge(city1, city2, distance);
        }
        br.close();
        return graph;
    }
}

