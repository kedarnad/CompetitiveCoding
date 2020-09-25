//import java.util;

import java.util.*;

public class ArrangeOrder {

    public static void arrangeOrder(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2))
                    return o2 - o1;
                else
                    return map.get(o1) - map.get(o2);
            }
        });

        for (int n : nums) queue.add(n);

        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }
    }

    public static void main(String[] args) {

        int nums[] = {3, 4, 2, 5, 2, 3, 4, 3, 6};
        arrangeOrder(nums);

        for (int n : nums) {
            System.out.print(n);
        }

    }

}
