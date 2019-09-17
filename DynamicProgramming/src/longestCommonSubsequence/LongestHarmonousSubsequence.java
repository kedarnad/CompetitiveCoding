package longestCommonSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmonousSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestHarmonousSubsequence().findLHS(new int[]{1, 1, 1, 1}));
    }

    public int findLHS(int[] nums) {
        //creating an array for a storing the memory value
        Map<Integer, Integer> hs = new HashMap<>();
        int maxNo = 1;

        int tempKey = 0;
        for (int i = 0; i < nums.length; i++) {

            if (hs.containsKey(nums[i])) {

                hs.put(nums[i], hs.get(nums[i]) + 1);
            } else {
                hs.put(nums[i], 1);
            }
            if (hs.containsKey(nums[i] - 1)) {
                tempKey = Math.max(tempKey, hs.get(nums[i] - 1) + hs.get(nums[i]));
//                hs.put(nums[i], tempKey+1);

            } else if (hs.containsKey(nums[i] + 1)) {
                tempKey = Math.max(hs.get(nums[i] + 1) + hs.get(nums[i]), tempKey);
//                hs.put(nums[i], tempKey+1);
            }

        }


//        for(int i: hs.values()){
//            if(maxNo<i)
//                maxNo=i;
//        }

        return tempKey;
    }
}
