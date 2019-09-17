package SetZeroMatrix;

public class SetZeroMatrix {

    /**
     * This program uses O(1) space complexity to convert and set zeros and a time of O(n^2)
     *
     * @param matrix
     */


    public static void setZeros(int[][] matrix) {
        /**
         * This is the main working function of the natrix
         */
        boolean firstRowZero = false, firstCollumnZero = false;
        /**
         * Checking if the first row has zero
         */

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        /**
         * Checking if the first row has zero
         */
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCollumnZero = true;
                break;
            }
        }

        /**
         * checking the rest of the matrix  and setting zeros in first row and collumn accordingly
         */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }


        /**
         * changing the rest of the rows and collumns of the matrix apart from the first and last row.
         */

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                nullCollumn(matrix, i);
        }

        for (int j = 1; j < matrix.length; j++) {
            if (matrix[j][0] == 0)
                nullRow(matrix, j);
        }


        if (firstRowZero) nullRow(matrix, 0);

        if (firstCollumnZero) nullCollumn(matrix, 0);


    }

    static void nullRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    static void nullCollumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int n[][];
        n = new int[][]{{3, 4, 5, 6}, {89, 1, 0, 3}, {11, 12, 13, 14}, {15, 16, 17, 0}};

        System.out.println("Before Conversion");


        printMatrix(n);

        setZeros(n);

        System.out.println("After Conversion");

        printMatrix(n);


    }
}
