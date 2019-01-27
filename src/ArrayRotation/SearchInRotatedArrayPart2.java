package ArrayRotation;

public class SearchInRotatedArrayPart2 {
//    public int solution(int[] nums, int target){
//
//        /**
//         * considering the leftmost and the rightmost element
//         */
//
//        int left=0;
//        int right=nums.length-1;
//
//        if(nums.length==1){
//            if(target==nums[0])
//                return 0;
//            else
//                return -1;
//        }
//        else if(nums.length==0)
//            return -1;
//
//
//        while(right>=left){
//
//            int mid= (left+right)/2;
//
//            if(nums[mid]==target)
//                return mid;
//
//            if(nums[mid]<nums[right]){
//
//                if(target<=nums[left] &&target>nums[mid]){
//                    left=mid+1;
//                }else{
//                    right=mid-1;
//                }
//
//            }else{
//                if(target<nums[mid] && target>=nums[left])
//                    right=mid-1;
//                else
//                    left=mid+1;
//
//            }
//
//        }
//
//        return -1;
//    }

    public static void main(String args[]) {

        int[] nums = {7, 8, 9, 10, 11, 2, 3};

        int[] nums1 = {1};

        int[] nums2 = {2, 3};

        int[] nums3 = {5, 1, 2, 3, 4};
        int[] nums5 = {7, 8, 9, 1, 3, 4};

        new SearchInRotatedArrayPart2().search(nums3, 1);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        // as everything is sorted, we just need to do binary search twice till we get a sorted set of array

        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[right]) {   // trying to get the sorted range

                if (target > nums[mid] && target <= nums[right])  // the normal binary search checking
                {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
