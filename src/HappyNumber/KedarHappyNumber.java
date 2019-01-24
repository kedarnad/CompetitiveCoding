package HappyNumber;

import java.util.HashSet;

public class KedarHappyNumber {
    public static void main(String args[]) {
        System.out.println(new KedarHappyNumber().isHappy(40));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> st = new HashSet<>();
        int ans = n;
//        int temp=0;

        while (ans != 1) {
            int sum = 0;

            while (ans > 0) {
                sum = (int) (sum + Math.pow(ans % 10, 2));
                ans = ans / 10;
            }


            if (st.contains(sum))
                return false;
            else {
                ans = sum;
//                temp=sum;
                st.add(sum);
            }
        }

        return true;

    }

}
