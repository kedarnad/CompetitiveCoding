package RemoveDups;

public class RemoveDups {

    public static void main(String[] args) {

        RemoveDups rm = new RemoveDups();
        int[] arr = {0, 1, 2, 3, 4, 4, 5};

        System.out.println(rm.removeDups(arr));
    }

    int removeDups(int[] arr) {

        int index = -1;
        if (arr == null || arr.length == 1) return 0;

        int i = 0, j = 1;
        //ith pointer ensures unique elements stays
        //jth pointer checks for other duplicate elements

        while (j < arr.length) {

            if (arr[i] == arr[j]) {
                j++;
            } else {

                i++;
                arr[i] = arr[j];
                j++;
            }

        }

        return i;


    }

}
