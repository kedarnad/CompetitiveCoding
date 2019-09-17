package FitNos;

public class FItNumbers {
    static int updateBits(int n, int m, int i, int j) {

        int allOnes = ~0;


        //Ones only before the position j
        int left = allOnes << (j + 1);

        System.out.println("left" + left);

        int right = ((1 << i) - 1);

        System.out.println("right" + right);

        //All 1s except for 0s between i and j. mask 111000011

        int mask = left | right;

        System.out.println("mask" + mask);

        //clear bits j through i
        int n_cleared = n & mask;
        int m_shifted = m << i; // move m into correct positions

        System.out.println("n_cleared" + n_cleared);
        System.out.println("m_shifted" + m_shifted);

        return n_cleared | m_shifted;

    }


    public static void main(String[] args) {


        int N = 2 ^ 10;
        int M = 35;

        System.out.println(updateBits(N, M, 2, 6));
        System.out.println(7 << 1);

        System.out.println(~0);
    }
}
