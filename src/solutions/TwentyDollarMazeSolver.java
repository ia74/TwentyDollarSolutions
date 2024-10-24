package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwentyDollarMazeSolver {
    public static class Point {
        public int row;
        public int col;
        public int moves = 0;
        public Point(int x, int y) {
            this.row = x;
            this.col = y;
        }
        public Point(int x, int y, int moves) {
            this(x, y);
            this.moves = moves;
        }
        public Point(Point start, int moves) {
            this(start.row, start.col);
            this.moves = moves;
        }
    };
    static Point[] moves = {
            new Point(1, 0),
            new Point(-1,0),
            new Point(0,1),
            new Point(0,-1)
    };
    public static int bfs(String[][] maze, Point start, boolean[][] visited) {
        Point location = new Point(start, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(location);
        visited[start.row][start.col] = true;
        while(!queue.isEmpty()) {
            Point toVisit = queue.poll();
            for (Point move : moves) {
                int row = toVisit.row + move.row;
                int col = toVisit.col + move.col;
                if (row >= 0 && col >= 0 &&
                    row < maze.length &&
                    col < maze[0].length &&
                    !visited[row][col] &&
                    !maze[row][col].equals("#"))
                {
                    if (maze[row][col].equals("E"))
                        return toVisit.moves + 1;
                    queue.add(new Point(row, col, toVisit.moves + 1));
                }
            }
        }
        return 0;
    };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr92.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while (noSets-- > 0) {
            String[] definition = scan.nextLine().split(" ");
            int rows = Integer.parseInt(definition[0]);
            int cols = Integer.parseInt(definition[1]);
            String[][] maze = new String[rows][cols];
            Point start = new Point(0, 0);
            for(int i = 0; i < rows; i++) {
                String line = scan.nextLine();
                String[] splat = line.split("");
                for(int j = 0; j < cols; j++) {
                    maze[i][j] = splat[j];
                    if(splat[j].equals("S")) {
                        start = new Point(i, j);
                    };
                }
            }
            boolean[][] visited = new boolean[rows][cols];
            int minSteps = bfs(maze, start, visited);
            System.out.println(minSteps);
//            System.out.println(Arrays.deepToString(maze));
        }
    }
}
