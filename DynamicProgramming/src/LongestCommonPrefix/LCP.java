package LongestCommonPrefix;

public class LCP {

    public static void main(String[] args) {

        String[] strs = {"le", "leet", "leetcode", "leee", "lelee"};
        LCP lcp = new LCP();

        String temp = lcp.longestCommonPrefix(strs);

        System.out.println(temp);
        System.out.println("leetcode".indexOf("lele"));


        //checking for the string temp of the lcp

        temp = lcp.longestCommonPrefix2(strs);
        System.out.println(temp);

    }

    /**
     * Approach 1: Longest Common prefix
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * This technique uses divide and conquere mechanism
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        return longestCommonPrefix2(strs, 0, strs.length - 1);

    }

    public String longestCommonPrefix2(String[] strs, int l, int r) {
        if (l == r) return strs[l];
        else {
            int mid = (l + r) / 2;

            String leftmostCommonPrefix = longestCommonPrefix2(strs, l, mid);
            String rightmostCommonPrefix = longestCommonPrefix2(strs, mid + 1, r);
            return findCommonPrefix(leftmostCommonPrefix, rightmostCommonPrefix);
        }
    }

    public String findCommonPrefix(String lString, String rString) {
        int min = Math.min(lString.length(), rString.length());
        for (int i = 0; i < min; i++) {
            if (lString.charAt(i) != rString.charAt(i)) {
                return lString.substring(0, i);
            }
        }
        return lString.substring(0, min);
    }
}
