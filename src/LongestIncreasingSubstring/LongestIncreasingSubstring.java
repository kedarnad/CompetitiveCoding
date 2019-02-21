package LongestIncreasingSubstring;

public class LongestIncreasingSubstring {

    public static void main(String args[]) {

        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubstring().lengthofLIS(nums));

    }

    public int lengthofLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] sumStorage = new int[nums.length];

        sumStorage[0] = 1;
        int ans = 1;

        for (int i = 0; i < sumStorage.length; i++) {
            int sumtillnow = 0;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    sumtillnow = Math.max(sumStorage[j], sumtillnow);

                }
            }

            sumStorage[i] = sumtillnow + 1;
            ans = Math.max(ans, sumStorage[i]);
        }

//        System.out.println("Printing sumStorage: "+ Arrays.toString(sumStorage));
        return ans;
    }
}
