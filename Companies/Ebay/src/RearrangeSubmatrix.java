import java.util.Arrays;
import java.util.Map;

public class RearrangeSubmatrix {

    public static void main(String[] args) {
        int[][] ogMatrix = {
                {1, 2, 6, 7},
                {5, 4, 9, 10},
                {11, 12, 16, 18},
                {14, 15, 19, 20}
        };


        int[][] cgMatrix = {
                {16, 18, 11, 13},
                {19, 20, 14, 15},
                {6, 7, 1, 2},
                {9, 10, 5, 4}
        };

        int k = 4;


        assert (Arrays.toString(ogMatrix).equals(Arrays.toString(cgMatrix)));
    }

    public int[] helper(int Row, int Col, int offset, int[][] ogMatrix) {
        int[] res = new int[offset * offset + 1];
        int count = 0;
        for (int i = Row; i < Row + offset; i++) {
            for (int j = Col; j < Col + offset; j++) {
                res[count++] = ogMatrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        return null;
    }

    public void createChange(int[][] matrix, Map<Integer, int[]> missingMap) {

    }

    public void rearrange(int[][] cgMatrix, int k) {
        int maxRow = cgMatrix.length;
        int maxCol = cgMatrix[0].length;

        if (maxRow == 0 && maxCol == 0 || maxCol == 1 || maxRow == 1) return;

        int offset = (int) Math.sqrt((maxRow * maxRow) / k);
        for (int row = 0; row < maxRow; row += offset) {
            for (int col = 0; col < maxCol; col += offset) {

            }
        }


//        return null;
    }
}
