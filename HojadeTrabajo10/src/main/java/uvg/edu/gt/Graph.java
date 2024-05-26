package uvg.edu.gt;

import java.util.*;

public class Graph {
    private final int INF = Integer.MAX_VALUE / 2;
    private int[][] adjMatrix;
    private Map<String, Integer> cityIndex;
    private List<String> cities;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int[] row : adjMatrix)
            Arrays.fill(row, INF);
        cityIndex = new HashMap<>();
        cities = new ArrayList<>();
    }

    public void addCity(String city) {
        if (!cityIndex.containsKey(city)) {
            cityIndex.put(city, cities.size());
            cities.add(city);
        }
    }

    public void addEdge(String city1, String city2, int distance) {
        int index1 = cityIndex.get(city1);
        int index2 = cityIndex.get(city2);
        adjMatrix[index1][index2] = distance;
    }

    public void removeEdge(String city1, String city2) {
        int index1 = cityIndex.get(city1);
        int index2 = cityIndex.get(city2);
        adjMatrix[index1][index2] = INF;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public List<String> getCities() {
        return cities;
    }
}

