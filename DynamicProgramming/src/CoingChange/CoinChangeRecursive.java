package CoingChange;

public class CoinChangeRecursive {

    public static int NoOfCombos(int arr[], int amt, int CurrentCoin) {
        if (amt == 0)
            return 1;
        if (amt < 0)
            return 0;

        int noOfCombos = 0;

        for (int coin = CurrentCoin; coin < arr.length; coin++) {
            noOfCombos += NoOfCombos(arr, amt - arr[coin], coin);

        }
        return noOfCombos;
    }


    public static void main(String[] args) {
        System.out.println(NoOfCombos(new int[]{1, 2}, 4, 0));
    }

    /**
     * The complexity of the problem is :
     */
}
