package SetIntersection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetIntersection {

    public static void main(String[] args) {

        int[] ds = new SetIntersection().intersection(new int[]{4, 9, 5, 4}, new int[]{9, 4, 9, 8, 4});

        for (int i : ds) {
            System.out.print(i);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result;
        List<Integer> ls = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        result = nums1.length < nums2.length ? nums1 : nums2;

        for (int i : nums1) {
            map.put(i, 1);
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }


        for (int i : map.keySet()) {
            if (map.get(i) % 2 == 0 || map.get(i) > 1)
                ls.add(i);
        }

        result = new int[ls.size()];
        int temp = 0;
        for (Integer i : ls) result[temp++] = i;


        return result;
    }
}
