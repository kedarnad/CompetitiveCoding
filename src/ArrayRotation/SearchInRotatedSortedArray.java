package ArrayRotation;

public class SearchInRotatedSortedArray {

//This function calculates the Smallest pivot in O(log(n))

    public static void main(String args[]) {

        int[] nums = {7, 8, 9, 10, 11, 2, 3};

        int[] nums1 = {1};

        int[] nums2 = {2, 3};

        System.out.println(new SearchInRotatedSortedArray().search(nums, 1));
    }

    public int findPivot(int[] nums, int left, int right) {

        if (right < left)
            return 0;

        if (right == left)
            return left;

        int mid = (left + right) / 2;

        if (mid < right && nums[mid + 1] < nums[mid])
            return mid + 1;

        if (mid > left && nums[mid - 1] > nums[mid])
            return mid;

        if (nums[right] > nums[left])
            return findPivot(nums, left, mid - 1);
        return findPivot(nums, mid + 1, right);
    }

    public int BinarySearch(int[] nums, int left, int right, int target) {

        int mid = (left + right) / 2;

        if (nums[mid] == target)
            return mid;

        if (right < left)
            return -1;

        else if (target > nums[mid])
            return BinarySearch(nums, mid + 1, right, target);
        else
            return BinarySearch(nums, left, mid - 1, target);

    }

    public int search(int[] nums, int target) {

        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int lowestIndex = findPivot(nums, 0, nums.length - 1);

        if (nums[lowestIndex] == target) {
//            System.out.println();
            return lowestIndex;
        } else if (lowestIndex == 0)
            return BinarySearch(nums, 0, nums.length - 1, target);
        else if (target < nums[0])
            return BinarySearch(nums, lowestIndex, nums.length - 1, target);
        return BinarySearch(nums, 0, lowestIndex - 1, target);
    }
}
