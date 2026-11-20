package Graph;

import java.util.*;

public class Graph<T> {
    // Map to store adjacency list: Vertex -> List of adjacent vertices
    private final Map<T, List<T>> adjList;
    private final boolean isDirected;

    // Constructor
    public Graph(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Default constructor: Undirected graph
    public Graph() {
        this(false);
    }

    // 1. Add a vertex
    public boolean addVertex(T vertex) {
        if (vertex == null || adjList.containsKey(vertex)) {
            return false;
        }
        adjList.put(vertex, new ArrayList<>());
        return true;
    }

    // 2. Add an edge
    public void addEdge(T source, T destination) {
        // Automatically add vertices if they don't exist
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source).add(destination);

        // If undirected, add reverse edge as well
        if (!isDirected) {
            adjList.get(destination).add(source);
        }
    }

    // 3. Remove an edge
    public boolean removeEdge(T source, T destination) {
        if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
            return false;
        }

        boolean removed = adjList.get(source).remove(destination);
        if (!isDirected) {
            adjList.get(destination).remove(source);
        }
        return removed;
    }

    // 4. Remove a vertex and all connected edges
    public boolean removeVertex(T vertex) {
        if (!adjList.containsKey(vertex)) {
            return false;
        }

        // Remove the vertex from all adjacent lists
        for (List<T> neighbors : adjList.values()) {
            neighbors.remove(vertex);
        }

        // Remove the vertex itself
        adjList.remove(vertex);
        return true;
    }

    // 5. Check if edge exists
    public boolean hasEdge(T source, T destination) {
        return adjList.containsKey(source) && adjList.get(source).contains(destination);
    }

    // 6. Check if vertex exists
    public boolean hasVertex(T vertex) {
        return adjList.containsKey(vertex);
    }

    // 7. Get neighbors of a vertex
    public List<T> getNeighbors(T vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());
    }

    // 8. Vertex count
    public int getVertexCount() {
        return adjList.size();
    }

    // 9. Breadth-First Search (BFS) Traversal
    public List<T> bfs(T startVertex) {
        List<T> traversalOrder = new ArrayList<>();
        if (!adjList.containsKey(startVertex)) {
            return traversalOrder;
        }

        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            traversalOrder.add(current);

            for (T neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    // 10. Depth-First Search (DFS) Traversal - Iterative
    public List<T> dfs(T startVertex) {
        List<T> traversalOrder = new ArrayList<>();
        if (!adjList.containsKey(startVertex)) {
            return traversalOrder;
        }

        Set<T> visited = new HashSet<>();
        Deque<T> stack = new ArrayDeque<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                traversalOrder.add(current);

                // Push neighbors onto stack (reverse order preserves left-to-right processing)
                List<T> neighbors = adjList.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    T neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return traversalOrder;
    }

    // 11. Print the graph structure
    public void printGraph() {
        for (Map.Entry<T, List<T>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Driver method for demonstration
    public static void main(String[] args) {
        // Example: Undirected Graph
        Graph<String> graph = new Graph<String>(false);

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");

        System.out.println("--- Adjacency List ---");
        graph.printGraph();

        System.out.println("\n--- BFS from 'A' ---");
        System.out.println(graph.bfs("A")); // Expected: [A, B, C, D, E, F]

        System.out.println("\n--- DFS from 'A' ---");
        System.out.println(graph.dfs("A")); // Expected: [A, B, D, E, C, F] (order may vary)

        System.out.println("\n--- Edge Check ---");
        System.out.println("Has edge A-B: " + graph.hasEdge("A", "B"));
        System.out.println("Has edge A-F: " + graph.hasEdge("A", "F"));

        System.out.println("\n--- Remove Vertex 'C' ---");
        graph.removeVertex("C");
        graph.printGraph();
    }
}