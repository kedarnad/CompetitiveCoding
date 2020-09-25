package Matrices;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String args[]) {


        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        return _getSpiralOrder(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    public List<Integer> _getSpiralOrder(int[][] matrix, int NoOfRows, int NoOfColumns) {
        int T = 0;
        int L = 0;
        int R = NoOfRows;
        int C = NoOfColumns;
        List<Integer> list = new LinkedList<>();

        int dir = 0; // initialised to go in the forward direction.

        while (T <= R && L <= C) {
            if (dir == 0) {
                for (int i = L; i <= C; i++) {
                    list.add(matrix[T][i]);
                }
                T++;
                dir = 1;
            } else if (dir == 1) {
                for (int i = T; i <= R; i++) {

                    list.add(matrix[i][C]);
                }
                C--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = C; i >= L; i--) {
                    list.add(matrix[R][i]);
                }
                R--;
                dir = 3;
            } else if (dir == 3) {
                for (int i = R; i >= T; i--) {
                    list.add(matrix[i][L]);
                }
                L++;
                dir = 0;
            }
            // dir= (dir+1)%4;
        }

        return list;
    }
}
