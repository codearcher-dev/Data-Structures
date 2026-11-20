package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortMatrix {
    static class Node{
        int row;
        int col;
        int val;

        Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public static ArrayList<Integer> sortedMatrix(ArrayList<ArrayList<Integer>> mat, int n) {
        ArrayList<Integer> result = new ArrayList<>(n * n);

        // Min-Heap ordered by element value
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // 1. Push the first element of each row into the Min-Heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Node(mat.get(i).get(0), i, 0));
        }

        // 2. Extract the minimum element and push the next element from the same row
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result.add(curr.val);

            if (curr.col + 1 < n) {
                minHeap.offer(new Node(mat.get(curr.row).get(curr.col + 1), curr.row, curr.col + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(10, 20, 30, 40)));
        list.add(new ArrayList<>(List.of(15, 20, 35, 42)));
        list.add(new ArrayList<>(List.of(27, 29, 37, 46)));
        list.add(new ArrayList<>(List.of(32, 33, 38, 49)));

        System.out.println(sortedMatrix(list,4));
    }
}
