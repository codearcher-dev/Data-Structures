package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

// Node based Implementation
public class Node {
    private int value;
    private int size;
    private ArrayList<Node> neighbours;

    public Node(int val) {
        this.value = val;
        this.size = 1;
        neighbours = new ArrayList<>();
    }

    public Node() {
        neighbours = new ArrayList<>();
    }

    public void addEdge(Node node) {
        this.neighbours.add(node);
        node.neighbours.add(this);
        size++;
    }

    private void traverse(Node root, HashSet<Node> visited) {
        if (visited.contains(root)) {
            return;
        }
        visited.add(root);
        System.out.println("Node added");
        for (Node node : root.neighbours) {
            traverse(node, visited);
        }
    }

    public HashSet<Node> traverse() {
        Node root = this;
        HashSet<Node> visited = new HashSet<>();
        traverse(root, visited);
        return visited;
    }

    private Node searchNode(int value, HashSet<Node> visited, Stack<Node> stack) {
        if (stack.isEmpty()) return null;
        if (stack.peek().value == value) {
            return stack.peek();
        }

        visited.add(stack.peek());
        for (Node node : stack.pop().neighbours) {
            if (!visited.contains(node)) {
                stack.push(node);
            }
        }

        return searchNode(value, visited, stack);
    }

    public Node searchNode(int value) {
        Node root = this;
        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        return searchNode(value, visited, stack);
    }

    public int size() {
        return this.size;
    }

    public int getValue() {
        return this.value;
    }

    public void printVal() {
        System.out.println(this.value);
    }

    public void printNode() {
        System.out.println(this.value);
    }

    public void printNeighbours() {
        System.out.print("[");
        for (int i = 0; i < this.neighbours.size(); i++) {
            System.out.print(this.neighbours.get(i).value + (i == this.neighbours.size() - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
