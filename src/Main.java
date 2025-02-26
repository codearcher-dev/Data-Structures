
import java.util.*;

import java.lang.*;

import java.io.*;


// Function signature should not be modified, else code

public class Main {

    public static int antSteps(int[] prohibited, int[] data) {

        int a = data[0], b = data[1], x = data[2];
        Set<Integer> forbidden = new HashSet<>();
        for (int pos : prohibited) {
            forbidden.add(pos);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // {position, steps, last_move_was_backward}
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int MAX_BOUND = 6000;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int pos = node[0], steps = node[1], lastBackward = node[2];

            if (pos == x) {
                return steps;
            }

            // Move Forward
            int forwardPos = pos + a;
            if (forwardPos <= MAX_BOUND && !forbidden.contains(forwardPos)) {
                String forwardKey = forwardPos + ",0";
                if (!visited.contains(forwardKey)) {
                    visited.add(forwardKey);
                    queue.offer(new int[]{forwardPos, steps + 1, 0});
                }
            }

            // Move Backward (if last move wasn't backward)
            if (lastBackward == 0) {
                int backwardPos = pos - b;
                if (backwardPos >= 0 && !forbidden.contains(backwardPos)) {
                    String backwardKey = backwardPos + ",1";
                    if (!visited.contains(backwardKey)) {
                        visited.add(backwardKey);
                        queue.offer(new int[]{backwardPos, steps + 1, 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] prohibited = {14, 4, 18, 1, 15};
        int[] data = {3, 15, 9};
        System.out.println(antSteps(prohibited, data)); // Output: 3}
    }
}