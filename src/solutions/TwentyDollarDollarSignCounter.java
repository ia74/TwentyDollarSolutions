package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwentyDollarDollarSignCounter {
    public static class Point {
        public int row;
        public int col;
        public int moves = -1;
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
                    !maze[row][col].equals("."))
                {
                    visited[row][col] = true;
                    if (maze[row][col].equals("$"))
                        toVisit.moves += 1;
                    else return toVisit.moves;
                    queue.add(new Point(row, col, toVisit.moves + 1));
                }
            }
        }
        return 0;
    };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr90.dat"));
        String[] definition = scan.nextLine().split(" ");
        int rows = Integer.parseInt(definition[0]);
        int cols = Integer.parseInt(definition[1]);
        String[][] maze = new String[rows][cols];
        Point start = new Point(0, 0);
        for(int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            String[] splat = line.split("");
            System.arraycopy(splat, 0, maze[i], 0, cols);
        }
        int num = scan.nextInt();
        scan.nextLine();
        Point[] starts = new Point[num];
        for(int i = 0; i < num; i++) {
            String line = scan.nextLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            starts[i] = new Point(a, b);
        }
        for (Point point : starts) {
            boolean[][] visited = new boolean[rows][cols];
            int minSteps = bfs(maze, point, visited);
            System.out.println(minSteps);
        }
    }
}
