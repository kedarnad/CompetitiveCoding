package StringWithKuniqueChars;

import java.util.Arrays;

public class StringWithUniqueChars {
    public static void main(String[] args) {

        StringWithUniqueChars scr = new StringWithUniqueChars();

        System.out.println(scr.countNoOfKLengthsubstrings("abc", 2));


    }

    int countNoOfKLengthsubstrings(String str, int k) {

        int[] chars = new int[26];
        int noofsubstrings = 0;

        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(chars, 0);
            int charcount = 0;

            for (int j = i; j < str.length(); j++) {
                if (chars[j] == 0) charcount++;
                chars[j]++;
                if (charcount == k)
                    noofsubstrings++;
            }
        }

        return noofsubstrings;
    }
}
