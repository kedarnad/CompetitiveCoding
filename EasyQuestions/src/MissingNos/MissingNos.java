package MissingNos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNos {

    public static void main(String[] args) {


        System.out.println(new MissingNos().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        //We need to use a Set and not linkedlist to avoid addition and removal of complexities
        //A hashset can help remove elements in O(1) while linkedlist will help remove in O(n)
        Set<Integer> ls = new HashSet<>();
        boolean flag = false;

        for (int i = 1; i <= nums.length; i++) {
            ls.add(i);
        }


        for (int i = 0; i < nums.length; i++) {

            ls.remove(nums[i]);
        }

        return ls.stream().collect(Collectors.toList());
    }


}
