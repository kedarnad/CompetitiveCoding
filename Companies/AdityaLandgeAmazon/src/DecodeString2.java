public class DecodeString2 {

    int pos = 0;

    public static void main(String[] args) {

        // testcases:
        DecodeString2 dcdr = new DecodeString2();
        System.out.println(dcdr.decode("kjl(ab(cde){2}ef){2}"));


    }

    public String decode(String str) {
        StringBuilder sbr = new StringBuilder();
//      StringBuilder num= new StringBuilder();
        for (int i = pos; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == '(') {
                int open = 1;
                int j = i + 1;

                while (open != 0) {
                    if (str.charAt(j) == '(') open++;
                    else if (str.charAt(j) == ')') open--;
                    j++;
                }

                String newStr = decode(str.substring(i + 1, j - 1));
                StringBuilder num = new StringBuilder();
                int k = j + 1;
                while (str.charAt(k) != '}') {
                    num.append(str.charAt(k));
                    k++;
                }
                i = k;
                for (int l = Integer.parseInt(num.toString()) - 1; l >= 0; l--) {
                    sbr.append(newStr);
                }
            } else {
                sbr.append(str.charAt(i));
            }
        }
        return sbr.toString();

    }
}
