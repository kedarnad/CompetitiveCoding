import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println(new TwoSum().twoSum(new int[]{4, 5, 6, 7}, 10));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hs = new HashMap<>();

        int count = 0;
        for (int i : nums) {
            int complement = target - i;

            if (hs.containsKey(complement)) {
                return new int[]{hs.get(complement), i};
            }

            hs.put(i, count);
            count++;
        }
        throw new IllegalArgumentException("No solutions to the two!");

    }
}
