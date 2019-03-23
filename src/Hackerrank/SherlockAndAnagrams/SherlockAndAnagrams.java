package Hackerrank.SherlockAndAnagrams;

import java.util.ArrayList;
import java.util.List;

public class SherlockAndAnagrams {


    private static boolean isAnagram(String one, String two) {
        char countS1[] = new char[26];
        char countS2[] = new char[26];

        for (char a : one.toCharArray()) {

            countS1[a - 'a']++;
        }

        for (char a : two.toCharArray()) {

            countS2[a - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countS1[i] != countS2[i])
                return false;
        }

        return true;
    }


    private static int getAnagramaticStrings(String s) {
        int count = 0;
        int length = s.length();

        //calculating the substrings and adding it into the arraylist
        List<String> subsets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                subsets.add(s.substring(i, i + j));
            }
        }

        //calculating the no of anagramatic pairs
        for (int i = 0; i < subsets.size(); i++) {
            for (int j = i + 1; j < subsets.size(); j++) {
                String s1 = subsets.get(i);
                String s2 = subsets.get(j);

                if (i != j && s1.length() == s2.length() && isAnagram(s1, s2)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(getAnagramaticStrings("abba"));
    }
}
