public class PalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstring().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    public String longestPalindrome(String s) {

        boolean[][] dpsub = new boolean[s.length()][s.length()];
        String longestString = "";

        int count = 0;
        int globalCount = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
//            count=0;
            for (j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (Math.abs(i - j) < 2) {
                        dpsub[i][j] = true;
                        if (Math.abs(i + 1 - j) > longestString.length()) {

                            longestString = s.substring(j, i + 1);
                        }

                    } else if (dpsub[i - 1][j + 1]) {
                        dpsub[i][j] = true;
                        if (Math.abs(i + 1 - j) > longestString.length()) {

                            longestString = s.substring(j, i + 1);
                        }
                    }
                } else
                    dpsub[i][j] = false;

                if (dpsub[i][j])
                    count++;

            }

        }

//        System.out.println(dpsub.length);
        return longestString;

    }
}
