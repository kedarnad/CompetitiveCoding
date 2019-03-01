package BulbsinLineLongestCommonProblem;

public class Bulbs {

    public static void main(String args[]) {

        int A[] = {2, 1, 3, 5, 4};
        int A1[] = {3, 1, 2};

        System.out.println(new Bulbs().solution(A1));


    }

    public boolean checkforprevious(int i, int elem, int[] arr) {

        int count = 0;
        for (int j = 0; j <= i; j++) {

            if (arr[j] <= elem)
                count++;
        }
        return count == elem;
    }

    public int solution(int[] arr) {
        int no_of_instances = 0;

        int temp[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (i < arr[i] - 1)
                continue;
            else {
                if (checkforprevious(i, arr[i], arr))
                    no_of_instances++;
            }
        }
        return no_of_instances;
    }
}
