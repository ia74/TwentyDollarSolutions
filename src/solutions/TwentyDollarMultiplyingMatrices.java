package solutions;

import java.beans.*;
import java.io.IOException;
import java.util.Arrays;

public class TwentyDollarMultiplyingMatrices {
    public static void main(String[] args) throws IOException {
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int outputIndices = matrixA.length + matrixB[0].length;
        int[] outputMatrix = new int[outputIndices];
        int c = 0;
        for (int[] row : matrixA) {
            for (int i = 0; i < matrixA.length; i++) {
                int[] col = generateColumn(matrixB, i);
                int dot = dotProduct(row, col);
                outputMatrix[c++] = dot;
            }
        }
        System.out.println(Arrays.toString(outputMatrix));
    }
    static int dotProduct(int[] a, int[] b) {
        int out = 0;
        for(int i = 0; i < a.length; i++) {
            int one = a[i];
            if(i < b.length) {
                int two = b[i];
                int mult = one * two;
                out += mult;
            } else {
                out += a[i];
            }
        }
        return out;
    }
    static int[] generateColumn(int[][] matrix, int index) {
        int[] col = new int[matrix.length];
        for(int i = 0; i < matrix[index].length+1; i++) {
            col[i] = matrix[i][index];
        }
        return col;
    }
}
