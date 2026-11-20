package Graph;
import java.util.ArrayList;

public class CycleInDirectedGraph {

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int u,
                              boolean[] visited, boolean[] recStack) {

        // Node is already in the current DFS path
        if (recStack[u])
            return true;

        // Node is already visited
        if (visited[u])
            return false;

        visited[u] = true;
        recStack[u] = true;

        // Visit all adjacent nodes
        for (int v : adj.get(u)) {
            if (dfs(adj, v, visited, recStack))
                return true;
        }

        // Remove node from current DFS path
        recStack[u] = false;

        return false;
    }

    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(adj, i, visited, recStack))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        System.out.println(isCyclic(adj) ? "true" : "false");
    }
}
