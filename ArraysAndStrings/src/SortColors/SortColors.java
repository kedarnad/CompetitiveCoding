package SortColors;

public class SortColors {

    public static void main(String[] args) {


        SortColors sc = new SortColors();
        int[] nums = {2, 2, 0, 2, 0, 0, 0};


        sc.sortColors(nums);

        for (int i : nums) {
            System.out.print(i + " \t");
        }
    }

    public void sortColors(int[] nums) {

        if (nums.length < 2) return;

        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {

            //checking for the first condition:
            if (nums[i] != 0 && nums[j] != 1) {
                swap(nums, i, j);
            }

            if (nums[j] != 1 && nums[k] < 2) {
                swap(nums, j, k);
            }

            if (nums[k] < 2 && nums[i] != 0) {
                swap(nums, i, k);
            }


            if (nums[i] == 0) i++;

            if (nums[j] == 1)
                j++;

            if (nums[k] == 2) k--;


        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
