package FindLowestAndHighestPositionOfSortedArrayElement;

public class FindLowestAndHighestPosition {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int mid = binarySearch(nums, 0, nums.length - 1, target);

        int low = mid, high = mid;

        if (mid == -1) return result;

        while (low > -1 && nums[low] == target) low--;

        while (high < nums.length && nums[high] == target) high++;


        return new int[]{low + 1, high - 1};


    }

    public static int binarySearch(int nums[], int low, int high, int target) {

        if ((high <= 0 || low >= nums.length - 1) && (nums[low] != target || nums[high] != target)) return -1;

        int mid = (low + high) / 2;

        if (nums[mid] == target) return mid;

        else if (nums[mid] < target) return binarySearch(nums, mid + 1, high, target);

        else if (nums[mid] > target) return binarySearch(nums, low, mid, target);


        return -1;

    }

    public static void main(String[] args) {

        int[] a = {5, 7, 7, 8, 8, 10};

        System.out.println(binarySearch(a, 0, a.length, 6));

        int[] result = searchRange(a, 7);

        for (int i : result) {
            System.out.print(i);
        }


    }
}
