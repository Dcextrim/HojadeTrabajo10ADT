package uvg.edu.gt;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = GraphLoader.loadGraph("guategrafo.txt", 100);
            FloydWarshall floydWarshall = new FloydWarshall(graph);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Ruta más corta");
                System.out.println("2. Ciudad centro del grafo");
                System.out.println("3. Modificar grafo");
                System.out.println("4. Salir");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (option == 1) {
                    System.out.println("Ingrese ciudad origen:");
                    String city1 = scanner.nextLine();
                    System.out.println("Ingrese ciudad destino:");
                    String city2 = scanner.nextLine();
                    System.out.println("Ruta más corta: " + floydWarshall.getPath(city1, city2, graph));
                } else if (option == 2) {
                    System.out.println("Ciudad centro del grafo: " + GraphCenter.getCenter(graph, floydWarshall));
                } else if (option == 3) {
                    System.out.println("1. Interrupción de tráfico");
                    System.out.println("2. Establecer conexión");
                    int subOption = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (subOption == 1) {
                        System.out.println("Ingrese ciudad1:");
                        String city1 = scanner.nextLine();
                        System.out.println("Ingrese ciudad2:");
                        String city2 = scanner.nextLine();
                        graph.removeEdge(city1, city2);
                    } else if (subOption == 2) {
                        System.out.println("Ingrese ciudad1:");
                        String city1 = scanner.nextLine();
                        System.out.println("Ingrese ciudad2:");
                        String city2 = scanner.nextLine();
                        System.out.println("Ingrese distancia:");
                        int distance = scanner.nextInt();
                        graph.addEdge(city1, city2, distance);
                    }
                    floydWarshall = new FloydWarshall(graph);  // Recalculate shortest paths
                } else if (option == 4) {
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}

