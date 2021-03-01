import java.util.LinkedList;
import java.util.List;

public class MonotoneDigits {

    public static int findMonotoneIncreasingOrder(int num) {
        String str = num + "";
        char[] nums = str.toCharArray();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(Integer.parseInt(String.valueOf(nums[i])));
        }
        int l = nums.length;

        for (int i = 0; i < l - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                // outer if condition :
                int balancer = 9 - (l - (i + 1));
                if (list.get(i) - 1 <= balancer) {
                    list.set(i, list.get(i) - 1);

                } else {

                    list.set(i, balancer);
                }


                for (int j = i + 1; i < l; i++) {
                    int y = 9 - (l - j + 1);
                    list.set(j, y);
                }

                String temp = "";
                for (int k = 0; i < list.size(); k++) {
                    temp += list.get(k) + "";
                }

                return Integer.parseInt(temp);

            }

        }


        return num;
    }

    public static void main(String[] args) {
//        System.out.println(findMonotoneIncreasingOrder(1000));

        String str = "ABC IS NOT EQUAL TO XYZ";
        //Standard method of conversion
        System.out.println(str.toLowerCase());
    }
}



