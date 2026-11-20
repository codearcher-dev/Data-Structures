package Graph;

import java.util.Arrays;

// Array Implementation (Adjacency Matrix)
public class MatrixGraph {
    private int v;

    int[][] adjMatrix;

    public MatrixGraph(int vertices){
        this.v = vertices;
        adjMatrix = new int[v+1][v+1];
    }

    public void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public void print(){
        for (int[] row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.print();
    }
}
