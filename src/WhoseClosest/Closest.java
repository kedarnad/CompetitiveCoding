package WhoseClosest;

import java.util.ArrayList;
import java.util.List;

public class Closest {


    public static List<Integer> closest(String s, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();

        for (int i : queries) {
            List<Integer> tempList = new ArrayList<>();
            char tofind = s.charAt(i);

            for (int j = 0; j < s.length(); j++) {

                if (i != j && s.charAt(i) == s.charAt(j)) {

                    tempList.add(j);
                }

                int min = 99999;

                for (int temp : tempList) {

                    if (min < Math.abs(temp - i))
                        min = temp;

                }

                if (min != 99999)
                    result.add(min);
                else
                    result.add(-1);


            }
        }

        return result;
    }

    public static void main(String args[]) {

        String s = "hackerrank";
        List<Integer> queries = new ArrayList<>();

        int[] que = {4, 1, 6, 8};

        for (int i : que) {
            queries.add(i);
        }

        System.out.println(closest(s, queries));

    }
}
