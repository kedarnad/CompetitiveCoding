package CountPalindromicSubsequences;

import java.util.HashSet;
import java.util.Set;

public class CpalindromeSubsequence {


    public static void main(String[] args) {
        CpalindromeSubsequence sp = new CpalindromeSubsequence();

        System.out.println(sp.palindromeCheck("cat"));

        System.out.println(sp.countAllPalindromicSubsequences("eleph"));

    }

    public boolean palindromeCheck(String str) {
        int st = 0, la = str.length() - 1;

        while (st <= la) {
            if (str.charAt(st) == str.charAt(la)) {
                ++st;
                --la;
            } else return false;
        }
        return true;
    }

    public int countAllPalindromicSubsequences(String str) {
        int iterations = (int) Math.pow(2, str.length());
        StringBuilder strTemp;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < iterations; i++) {
            strTemp = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if ((i & (1 << j)) > 0) {
                    strTemp.append(str.charAt(j));
                }
            }
//            System.out.println(strTemp.toString());
            if (palindromeCheck(strTemp.toString())) {
                set.add(strTemp.toString());
                System.out.println(strTemp.toString());
            }
        }
        return set.size() - 1;
    }

    /**
     * Trying to solve a problem in recursive way
     *
     * @param int[] given_array
     */
    public void countDPPalindromes(int[] given_arr) {
        int[] subsets = new int[given_arr.length];
        helper(given_arr, subsets, 0);

    }

    public void helper(int[] given_arr, int[] subsets, int index) {
        if (index == given_arr.length)
            print_subsets(subsets);

    }

    public void print_subsets(int[] subsets) {

    }
}
