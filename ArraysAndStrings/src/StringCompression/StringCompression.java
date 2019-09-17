package StringCompression;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    /**
     * In this code we try to find the length of the strings initially itself.
     *
     * @param str
     * @return
     */

    public static String stringComp(String str) {
        if (str.equals("")) return "";

        List<Character> ls = new ArrayList<>();
        int countCompressedLenght;
        if ((countCompressedLenght = countCompressedLength(str)) > str.length())
            return str;

        StringBuilder ls1 = new StringBuilder(countCompressedLenght);
        int count = 1;
        for (int i = 0; i < str.length(); i++) {

            if ((i + 1 < str.length()) && str.charAt(i) == str.charAt(i + 1)) count++;
            else {
                ls1.append(str.charAt(i));
                ls1.append(count);
                count = 1;
            }

        }
        return ls1.toString();
    }


    public static int countCompressedLength(String str) {

        int countlength = 0;
        int countStr = 1;
        for (int i = 0; i < str.length(); i++) {

            if ((i + 1 < str.length()) && str.charAt(i) == str.charAt(i + 1)) countStr++;
            else {
                countlength += 1 + String.valueOf(countStr).length();
            }

        }


        return countlength;
    }

    public static void main(String[] args) {
        System.out.println(stringComp("a"));

    }
}
