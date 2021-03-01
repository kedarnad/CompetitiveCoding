import java.util.HashSet;
import java.util.Set;

public class PatternMatching {
    /**
     * @param s
     * @param p
     * @return amazing =7
     * 010 3
     * start =0 0+3=
     */

    public static int Match(String s, String p) {
        int matches = 0;
        int slen = s.length();
        int plen = p.length();

        Set<Character> set = new HashSet<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
//        set.addAll(Arrays.asList(vowels));
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('y');

        int start = 0;
        int count = 0;
        while (start + plen < slen) {
            boolean flag = true;
            for (int i = start; i <= start + plen - 1; i++) {
                if (p.charAt(i - start) == '0') {
                    if (!set.contains(s.charAt(i))) {
                        flag = false;
                        break;
                    }
                } else {
                    if (set.contains(s.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
            flag = false;
            start++;
        }
        return count;
    }


    public static String editString(int n, String[] operations) {

        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbr.append('0');
        }

        for (int i = 0; i < operations.length; i++) {

            if (operations[i].charAt(0) == 'L') {

            } else if (operations[i].charAt(0) == 'C') {


            }

        }


        return "";
    }

    public static void main(String[] args) {
        System.out.println(Match("codesignal", "000"));
    }


}
