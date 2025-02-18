package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwentyDollarTarget {
    public static class Point {
        public int row;
        public int col;
        public int moves = 0;
        public Point(int x, int y) {
            this.row = x;
            this.col = y;
            System.out.println("Creating point at " + x +"x"+ y);
        }
        public Point(int x, int y, int moves) {
            this(x, y);
            this.moves = moves;
        }
        public Point(Point start, int moves) {
            this(start.row, start.col);
            this.moves = moves;
        }

        @Override
        public String toString() {
            return row +"x" + col +"~" + moves;
        }
    };
    public static int[][] bfs(int[][] e, Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int column_direction = 1;
        int row_direction = 0;
        int maxColumns = e[0].length;
        int maxRows = e.length;
        int[][] output = new int[maxColumns][maxRows];
        boolean[][] visited = new boolean[maxColumns][maxRows];
        while(!queue.isEmpty()) {
            Point visiting = queue.poll();
            int row = visiting.row + row_direction;
            int col = visiting.col + column_direction;
            output[visiting.row][visiting.col] = visiting.moves;
            if (row >= 0 && col >= 0 &&
                    row < maxRows &&
                    col < maxColumns && !visited[row][col])
            {
                visited[row][col] = true;
                queue.add(new Point(row, col, visiting.moves + 1));
            } else if(col == maxColumns) {
                row -= row_direction;
                col -= column_direction;
                column_direction = 0;
                row_direction = 1;
                row += 1;
                System.out.println("Step: col==maxColumns");
                visited[row][col] = true;
                queue.add(new Point(row, col, visiting.moves + 1));
            } else if (row == maxRows) {
                row -= row_direction;
                col -= column_direction;
                column_direction = -1;
                row_direction = 0;
                col -= 1;
                System.out.println("Step: row==maxRows");
                visited[row][col] = true;
                queue.add(new Point(row, col, visiting.moves + 1));
            } else {
                if(column_direction + row_direction == 0) {
                    maxColumns--;
                }
                    if(row - row_direction-1 <= 0) {
                        System.out.println("HELOELO " + new Point(row, col));
                        maxRows--;
                        maxColumns--;
                        column_direction = 1;
                        row_direction = 0;
                        output[0][0] = 1;
                        queue.add(new Point(row+2, col, visiting.moves-1));
                        continue;
                    }
                if(!visited[row-row_direction - 1][col-column_direction]) {
                    row -= row_direction;
                    col -= column_direction;
                    column_direction = 0;
                    row_direction = -1;
                    row -= 1;
                    if(row <= 0) {
                        column_direction = 1;
                        row_direction = 0;
                    } else {
                    System.out.println("Hello?");
                        visited[row][col] = true;
                        queue.add(new Point(row, col, visiting.moves + 1));
                    }
                }
            }
//            printT(output);
        }
        return output;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("target.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while (noSets-- > 0) {
            int n = scan.nextInt();
            int[][] a = new int[n][n];
            printT(
                    bfs(a, new Point(0, 0, 1))
            );
        }
    }
    public static void printT(int[][] p) {
        Arrays.stream(p).forEach((g) -> {
            Arrays.stream(g).forEach((e) -> {
                System.out.print(e+" ");
            });
            System.out.println();
        });
        System.out.println();
    }
}
