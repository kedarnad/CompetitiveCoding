package SingleNos;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public int singleNumber(int[] nums) {
   Set<Integer> hash = new HashSet<Integer>(); 
     for(int i=0;i<nums.length;i++)
     {
         if(hash.contains(nums[i]))
             hash.remove(nums[i]);
         else
             hash.add(nums[i]);
         
     }
        return hash.iterator().next();
    }
}
