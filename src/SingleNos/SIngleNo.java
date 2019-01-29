package SingleNos;

import java.util.HashMap;

public class SIngleNo {

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i : nums)
            hs.put(i, 0);

        for (int i : nums)
            hs.put(i, hs.get(i) + 1);


        for (int i : hs.keySet())
            if (hs.get(i) == 1)
                return i;


        return 0;
    }


    public static void main(String args[]) {

        int nums[] = {1, 2, 3, 2, 3};


        System.out.println(singleNumber(nums));
    }


}
