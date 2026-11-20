package DynamicProgramming;

// You are allowed to move only down or right from start (0, 0) to end (m, n)
public class WaysToReachEnd {
    public int ways(int m,int n){
        int[][] maze = new int[m][n];

        for(int i = 0 ; i < maze.length ; i++){
            for(int j = 0 ; j < maze[i].length ; j++){
                if(i == 0 || j == 0){
                    maze[i][j] = 1;
                }
            }
        }
        for(int i = 1 ; i < maze.length ; i++){
            for(int j = 1 ; j < maze[i].length ; j++){
                maze[i][j] = maze[i-1][j] + maze[i][j-1];
            }
        }
        return maze[m-1][n-1];
    }

    public static void main(String[] args) {
        WaysToReachEnd obj = new WaysToReachEnd();

        System.out.println(obj.ways(6,6));
    }
}
