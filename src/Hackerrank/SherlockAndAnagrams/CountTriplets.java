package Hackerrank.SherlockAndAnagrams;

public class CountTriplets {

    private static int counttriplets(int[] arr, int r) {
        int countTriplets = 0;

        for (int i = 1; i < arr.length - 1; i++) {


            for (int prev = i - 1; prev >= 0; prev--) {

                for (int next = i + 1; next < arr.length; next++) {


                    if (arr[i] % arr[prev] == 0 && arr[next] % arr[i] == 0 && arr[i] / arr[prev] == r && arr[next] / arr[i] == r) {
                        countTriplets++;
                    }
                }

            }

        }


        return countTriplets;
    }


    public static void main(String[] args) {

        int arr[] = {1, 3, 9, 9, 27, 81};
        int n = 3;

        System.out.println(counttriplets(arr, n));
    }


}
