public class findmax {

    public static void main(String[] args) {


        System.out.println(new findmax().findmax(-99));
    }

    public int findmax(int m) {

        String n = m + "";

        char[] arr = n.toCharArray();
        String newNum = "";

        if (n.charAt(0) == '-') {
            int i = 1;
            System.out.println(n.charAt(i));
            System.out.println(Character.getNumericValue(n.charAt(i)) < 5);
            while (Character.getNumericValue(n.charAt(i)) < 5) {
                i++;
                if (i >= n.length()) break;
            }


            newNum = n.substring(0, i);
            newNum += '5';

            newNum += n.substring(i);
        } else {
            int i = 0;

            while (Character.getNumericValue(n.charAt(i)) > 5) {
                i++;
                if (i >= n.length())
                    break;
            }

            newNum = "";
            newNum = n.substring(0, i);
            newNum += '5';
            newNum += n.substring(i);
        }


        return new Integer(newNum);
    }
}
