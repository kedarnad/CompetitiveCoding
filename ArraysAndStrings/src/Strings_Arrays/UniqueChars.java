package Strings_Arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueChars {

    public static boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'A';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static int countUniqueChars(String string) {

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            if (!map.containsKey(string.charAt(i)))
                map.put(string.charAt(i), 1);
            else map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
        }

        for (int i : map.values()) if (i == 1) count++;

        return count;

    }

    public static int countUniqueSubstring(String str) {
        int count = 0;
//        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

//                    hs.add(str.substring(i,j));
                count += countUniqueChars(str.substring(i, j));

            }
        }
//        System.out.println(hs);
        return (int) (count % ((Math.pow(10, 9) + 7)));
    }

    public static void main(String[] args) {
        String name = "abbcd";
        String name2 = "abcdef";
//        System.out.println(isUnique(name2));

        String name1 = "ABBB";
        System.out.println(countUniqueSubstring(name1));
//        System.out.println(name1.substring(0,3));


//        System.out.println(countUniqueChars("ABA"));
    }

}
