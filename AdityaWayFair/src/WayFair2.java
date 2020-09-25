public class WayFair2 {


    public static void main(String[] args) {
        WayFair2 wayFair2 = new WayFair2();
        System.out.println(wayFair2.solution(99699));
    }

    public int solution(int A) {

        String numStr = String.valueOf(A);

        int i = 0;
        while (i < numStr.length() && numStr.charAt(i) == '9') {
            i++;
        }

        StringBuilder firstPart = new StringBuilder();

        firstPart.append(numStr, 0, i);

        if (i < numStr.length()) {
            firstPart.append('9');
            firstPart.append(numStr.substring(i + 1));
        }


        return Integer.parseInt(String.valueOf(firstPart));
    }
}
