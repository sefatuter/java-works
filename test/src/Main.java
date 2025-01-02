import java.util.*;
import java.util.stream.Collectors;

class Graph {
    // Inner class to represent an edge with a source, destination, and weight
    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    // List to store all edges
    private List<Edge> edges;
    // Set to store all vertices
    private Set<Integer> vertices;

    private static final int INFINITY = Integer.MAX_VALUE;

    // Constructor
    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new HashSet<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        vertices.add(vertex);
    }

    // Method to add a directed edge to the graph
    public void addEdge(int from, int to, int weight) {
        addVertex(from);
        addVertex(to);
        edges.add(new Edge(from, to, weight));
    }

    // Method to perform Bellman-Ford algorithm
    public BellmanFordResult bellmanFord(int startVertex) {
        // Initialize distances to all vertices as infinity, except the start vertex
        Map<Integer, Integer> distances = new HashMap<>();
        for (Integer vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        // Predecessors for path reconstruction
        Map<Integer, Integer> predecessor = new HashMap<>();

        // Relax all edges |V| - 1 times
        int numVertices = vertices.size();
        for (int i = 1; i <= numVertices - 1; i++) {
            boolean updated = false;
            System.out.println("\n--- Iteration " + i + " ---");
            for (Edge edge : edges) {
                if (distances.get(edge.from) != Integer.MAX_VALUE) {
                    long newDistance = (long) distances.get(edge.from) + edge.weight;
                    if (newDistance < distances.get(edge.to)) {
                        distances.put(edge.to, (int) newDistance);
                        predecessor.put(edge.to, edge.from);
                        updated = true;
                        System.out.println("Relaxing edge " + edge.from + " -> " + edge.to + " with weight " + edge.weight +
                                ": Updated distance to " + edge.to + " = " + newDistance);
                    }
                }
            }
            if (!updated) {
                System.out.println("No updates in this iteration. Early termination.");
                break;
            }
        }

        // Check for negative-weight cycles
        System.out.println("\n--- Checking for Negative Weight Cycles ---");
        for (Edge edge : edges) {
            if (distances.get(edge.from) != Integer.MAX_VALUE) {
                long newDistance = (long) distances.get(edge.from) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    System.out.println("Negative weight cycle detected via edge " + edge.from + " -> " + edge.to);
                    return new BellmanFordResult(true, null, null);
                }
            }
        }

        return new BellmanFordResult(false, distances, predecessor);
    }

    // Helper class to store the result of Bellman-Ford
    static class BellmanFordResult {
        boolean hasNegativeCycle;
        Map<Integer, Integer> distances;
        Map<Integer, Integer> predecessor;

        BellmanFordResult(boolean hasNegativeCycle, Map<Integer, Integer> distances, Map<Integer, Integer> predecessor) {
            this.hasNegativeCycle = hasNegativeCycle;
            this.distances = distances;
            this.predecessor = predecessor;
        }
    }

    // Helper method to construct the path from start to end using the predecessor map
    private static List<Integer> constructPath(int start, int end, Map<Integer, Integer> predecessor) {
        LinkedList<Integer> path = new LinkedList<>();
        Integer current = end;
        while (current != null && current != start) {
            path.addFirst(current);
            current = predecessor.get(current);
        }
        if (current == null) { // No path found
            return Collections.emptyList();
        }
        path.addFirst(start);
        return path;
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Create the graph
        Graph graph = new Graph();

        // Add edges with weights (including a negative edge)
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, -2);
        graph.addEdge(3, 2, 2);// Negative edge

        // Run Bellman-Ford algorithm from vertex 0
        int startVertex = 0;
        System.out.println("Running Bellman-Ford Algorithm from vertex " + startVertex + ":");
        BellmanFordResult result = graph.bellmanFord(startVertex);

        if (result.hasNegativeCycle) {
            System.out.println("\nA negative weight cycle was detected in the graph.");
        } else {
            System.out.println("\nNo negative weight cycle detected.");
            System.out.println("\nShortest distances from vertex " + startVertex + ":");
            // Sort the vertices for consistent output
            List<Integer> sortedVertices = new ArrayList<>(graph.vertices);
            Collections.sort(sortedVertices);
            for (Integer vertex : sortedVertices) {
                if (result.distances.get(vertex) < INFINITY) {
                    List<Integer> path = constructPath(startVertex, vertex, result.predecessor);
                    if (path.isEmpty()) { // No path found
                        System.out.println("Distance to vertex " + vertex + ": Not reachable");
                    } else {
                        String pathStr = path.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(" -> "));
                        System.out.println("Distance to vertex " + vertex + ": " + result.distances.get(vertex) + " (Path: " + pathStr + ")");
                    }
                } else {
                    System.out.println("Distance to vertex " + vertex + ": Not reachable");
                }
            }
        }
    }
}
