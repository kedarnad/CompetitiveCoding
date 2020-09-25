import java.util.ArrayList;
import java.util.List;

public class StorageAnalysis {
    public static int minStorageSpace(int numComputers, int[] hardDiskSpace, int segmentLength) {
        int start = 0;
        int big = 0;
        List<Integer> temp = new ArrayList<>();
        int currMin = Integer.MAX_VALUE;
        int overallLarge = Integer.MIN_VALUE;

        while (big < numComputers) {
            while ((big - start + 1) != segmentLength) {
//               currMin=Math.min(currMin, hardDiskSpace[big]);
                big++;
            }
            currMin = Integer.MAX_VALUE;
            for (int i = start; i <= big; i++) {
                currMin = Math.min(currMin, hardDiskSpace[i]);
            }
            temp.add(currMin);
            start++;
            big++;
        }

        for (int i : temp)
            overallLarge = Math.max(overallLarge, i);

        return overallLarge;

    }


    public static void main(String[] args) {
        System.out.println(minStorageSpace(3, new int[]{8, 2, 4}, 1));

    }
}
