package Graph;

import java.util.*;

public class WeightedGraph {
    private int v;
    ArrayList<AbstractMap<Integer, Integer>> adjList;

    public WeightedGraph(int vertices) {
        this.v = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adjList.add(new HashMap<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).put(v,weight);
        adjList.get(v).put(u,weight);
    }

    public void print(){
        for (AbstractMap<Integer,Integer> row: adjList){
            System.out.println(row);
        }
    }
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        graph.addEdge(1, 2,2);
        graph.addEdge(1, 3,3);
        graph.addEdge(2, 4,1);
        graph.addEdge(2, 5,6);
        graph.addEdge(3, 4,4);
        graph.addEdge(4, 5,3);

        graph.print();
    }

}
