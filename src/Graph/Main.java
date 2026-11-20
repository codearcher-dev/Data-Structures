package Graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node graph = new Node();
        graph.addEdge(new Node(5));
        graph.addEdge(new Node(3));
        graph.addEdge(new Node(7));
        graph.printNode();
        graph.searchNode(3).addEdge(graph.searchNode(7));
        graph.searchNode(5).addEdge(graph.searchNode(7));
        graph.searchNode(3).addEdge(graph.searchNode(5));
        graph.searchNode(3).addEdge(new Node(8));
        graph.searchNode(3).printNeighbours();
    }
}
