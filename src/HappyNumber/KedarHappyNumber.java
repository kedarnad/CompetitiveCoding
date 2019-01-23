package HappyNumber;

public class KedarHappyNumber {
    public static boolean isHappy(int n) {

        int ans = n;

        while (ans != 1) {
            int sum = 0;

            while (ans > 0) {
                sum = (int) (sum + Math.pow(ans % 10, 2));
                ans = ans / 10;
            }

            ans = sum;
        }

        return true;
    }


    public static void main(String args[]) {
        System.out.println(isHappy(91));
    }

}
