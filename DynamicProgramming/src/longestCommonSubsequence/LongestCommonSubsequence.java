package longestCommonSubsequence;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().findLHS(new int[]{4, 5, 6, 5, 8, 14, 15, 28}));
    }

    public int findLHS(int[] nums) {
        int dpNum[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {

            if (Math.abs(nums[i] - nums[i - 1]) <= 1) {
                dpNum[i] = dpNum[i - 1] + 1;
            }
        }

        int max = 0;

        for (int i = 0; i < dpNum.length; i++) {
            if (max < dpNum[i])
                max = dpNum[i];

//            System.out.println(dpNum[i]);
        }
        return max + 1;
    }
}
