package StringCostGoogleTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringCost {
    static String finalStr = "";

    public static String solve(int[] cost, int target) {
        Map<Integer, String> map = new HashMap<>();
//        System.out.println("Hello");
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        solveString(cost, 0, target, 25, map, pq, new StringBuilder());
//
        return pq.poll();
    }

    public static String solveString(int[] cost, int currCost, int target, int index, Map<Integer, String> map, PriorityQueue<String> pq, StringBuilder sbr) {
        if (target == currCost)
            return sbr.toString();

        if (map.containsKey(currCost))
            return map.get(currCost);

        String currTemp = "";

        for (int i = index; i >= 0; i--) {

        }

        return "";
    }


    public static void main(String[] args) {

        System.out.println((char) (122 - (25 - 25)));
        String temp = solve(new int[]{237, 891, 429, 358, 145, 851, 174, 670, 571, 747, 238, 391, 689, 144, 561, 383,
                56, 508, 777, 705, 733, 730, 292, 524, 519, 996}, 588);

    }

}



