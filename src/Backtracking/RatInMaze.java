package Backtracking;

import Generics.Conversion;

import java.util.ArrayList;

public class RatInMaze {

//    public int wayCount(int[][] maze) {
//        return wayCount(maze, 0, 0);
//    }
//
//    private int wayCount(int[][] maze, int i, int j) {
//        if (i < 0 || j < 0) return 0;
//        if (i == maze.length - 1 && j == maze[i].length - 1) return 1;
//        if (i >= maze.length || j >= maze[i].length) return 0;
//        if (maze[i][j] == 1) {
//            int d = wayCount(maze, i + 1, j);
//            int r = wayCount(maze, i, j + 1);
//            return d + r;
//        } else {
//            return 0;
//        }
//    }


    public int wayCount(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[maze.length - 1].length];
        return wayCount(maze, 0, 0, visited);
    }

    private int wayCount(int[][] maze, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0) return 0;
        if (i == maze.length - 1 && j == maze[i].length - 1) {
            visited[i][j] = true;
            Conversion<Integer> obj = new Conversion<>();
            obj.printToString(visited);
            System.out.println("--------------------------------------------");
            return 1;
        }
        if (i >= maze.length || j >= maze[i].length) return 0;
        if (visited[i][j]) return 0;
        if (maze[i][j] == 1) {
            visited[i][j] = true;
            int u = wayCount(maze, i - 1, j, visited);
            int d = wayCount(maze, i + 1, j, visited);
            int l = wayCount(maze, i, j - 1, visited);
            int r = wayCount(maze, i, j + 1, visited);

            return d + r + u + l;
        } else {
            return 0;
        }

    }

    public ArrayList<String> ways(int[][] maze) {
        return ways(maze, 0, 0, "", "");
    }

    private ArrayList<String> ways(int[][] maze, int i, int j, String way, String dir) {
        if (i < 0 || j < 0) return new ArrayList<>();
        if (i == maze.length - 1 && j == maze[i].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            way += dir;
            list.add(way);
            return list;
        }
        if (i >= maze.length || j >= maze[i].length) return new ArrayList<>();
        if (maze[i][j] == 1) {
            way += dir;
            ArrayList<String> down = ways(maze, i + 1, j, way, "D");
            ArrayList<String> right = ways(maze, i, j + 1, way, "R");
            down.addAll(right);
            return down;
        }
        return new ArrayList<>();
    }


    public int paths(int[][] grid, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int obs = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else if (grid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        new Conversion<Integer>().printToString(dp);
        return dp[m][n];
    }


    public static void main(String[] args) {
//        int[][] maze = {
//                {1, 0, 0, 0},
//                {1, 1, 0, 1},
//                {1, 1, 0, 0},
//                {0, 1, 1, 1}
//        };
        int[][] maze = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };

        int[][] path = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };
        RatInMaze obj = new RatInMaze();
//
        System.out.println(obj.ways(maze));
//        System.out.println(obj.wayCount(maze));
//        System.out.println(obj.paths(path,path.length,path[0].length));
    }
}
