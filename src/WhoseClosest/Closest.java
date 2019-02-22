package WhoseClosest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Closest {


    public static List<Integer> closest(String s, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();

        for (int i : queries) {
            List<Integer> tempList = new ArrayList<>();
            char tofind = s.charAt(i);
            HashMap<Integer, Integer> hs = new HashMap<>();
            int min = 9999;
            int minresult = 99999;


            for (int j = 0; j < s.length(); j++) {

                if (i != j && s.charAt(i) == s.charAt(j)) {
                    tempList.add(j);

                    if (!hs.containsKey(Math.abs(j - i))) {
                        hs.put(Math.abs(j - i), j);
                        if (min > j)
                            min = j;
                    } else {
                        if (min > j) {
                            min = j;
                            hs.put(Math.abs(j - i), min);
                        }
                    }
                }

                minresult = 99999;
//
                for (int temp : hs.keySet()) {
                    if (minresult > temp)
                        minresult = temp;
                }
//
            }
            if (hs.containsKey(minresult))
                result.add(hs.get(minresult));
            else if (hs.size() == 0)
                result.add(-1);
        }
        return result;
    }

    public static void main(String args[]) {

        String s = "aaaa";
        List<Integer> queries = new ArrayList<>();

        int[] que = {0,
                1,
                2,
                3};

        for (int i : que) {
            queries.add(i);
        }

        System.out.println(closest(s, queries));

    }
}
