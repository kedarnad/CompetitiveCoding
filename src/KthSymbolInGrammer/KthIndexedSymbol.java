package KthSymbolInGrammer;

import java.util.Arrays;

public class KthIndexedSymbol {

    long temp, newVar;

    public static void main(String args[]) {

        System.out.println(new KthIndexedSymbol().KthGrammer(3, 2));

    }

    public int KthGrammer(int N, int K) {

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], 0);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i + 1][j] = 0;
                    matrix[i + 1][j + 1] = 1;
                } else {
                    matrix[i + 1][j] = 1;
                    matrix[i + 1][j + 1] = 0;
                }
            }
        }

        return matrix[N - 1][K - 1];
    }
}
