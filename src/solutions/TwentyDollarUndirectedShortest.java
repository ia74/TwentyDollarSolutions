package solutions;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TwentyDollarUndirectedShortest {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr130.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        int[][] adjMatr = new int[100][100];
        int idx = 0;
        while(sets-- > 0) {
            String[] x_y = scan.nextLine().split(" ");

            String x = x_y[0];
            String y = x_y[1];

            if(!map.containsKey(x)) map.put(x, idx++);
            if(!map.containsKey(y)) map.put(y, idx++);
            int idx_x = map.get(x);
            int idx_y = map.get(y);

            adjMatr[idx_x][idx_y] = 1;
            adjMatr[idx_y][idx_x] = 1;
        }

        int findingSets = scan.nextInt();
        scan.nextLine();

        loopy:
        while(findingSets-->0) {
            String[] start_end = scan.nextLine().split(" ");
            int startIndex = map.get(start_end[0]);
            int endIndex = map.get(start_end[1]);
            boolean[] visited = new boolean[map.size()];
            Queue<int[]> nextMoves = new LinkedList<>();
            visited[startIndex] = true;
            nextMoves.add(new int[] {startIndex, 0});

            while(!nextMoves.isEmpty()) {
                int[] move = nextMoves.poll();

                for(int i = 0; i < map.size(); i++) {
                    if(adjMatr[move[0]][i] == 1 && !visited[i]) {
                        if(i == endIndex) {
                            System.out.println(move[1]+1);
                            continue loopy;
                        }
                    } else {
                        nextMoves.add(new int[] {
                                move[0]+1, move[1]+1
                        });
                    }
                }
            }
        }
    }
}