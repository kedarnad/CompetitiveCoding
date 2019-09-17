package MatrixRotation;

public class RotateMatrix {

    static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;// checking the length of the matrix

        for (int layer = 0; layer < n / 2; layer++) {

            /**
             * First iteration done for going from the outer layer to the innermost layer
             */
            int first = layer; //element in each row of the expression
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;


                int top = matrix[first][i]; // changing the first of the first element
                //left to top

                matrix[first][i] = matrix[last - offset][first]; // changing the  second of the first element
                //bottom to left

                matrix[last - offset][first] = matrix[last][last - offset];
                //right to bottom

                matrix[last][last - offset] = matrix[i][last];
                //top to right

                matrix[i][last] = top;

            }

        }

        return true;
    }

    static void rotateMatrix2(int[][] matrix) {
        /**
         * This is the part2 way of rotating elements of a matrix
         */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;

            }
        }


    }

    public static void main(String[] args) {
        int n[][];
        n = new int[][]{{3, 4, 5, 6}, {0, 1, 2, 3}, {11, 12, 13, 14}, {15, 16, 17, 18}};

        System.out.println("Before rotation");

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j] + "\t");
            }
            System.out.println("\n");

        }

//        System.out.println(rotate(n));

        rotateMatrix2(n);


        System.out.println("After ROtation:");

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j] + "\t");
            }
            System.out.println("\n");

        }
    }
}
