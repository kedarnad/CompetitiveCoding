import java.util.*;

public class SnowflakeChaitanya {
    static int[][] dirs = {{0, 1}, {1, 0}};

    public static int countPairs(int[] nums, int k) {
        int count = 0;

        Arrays.sort(nums);
        int last = nums.length - 1;
        int first = 0;

        Set<List<Integer>> pairs = new HashSet<>();
        while (first < last) {
            int temp = last - first;
            if (temp == k) {

                pairs.add(Arrays.asList(first, last));
                count++;
                first++;
                last--;

            } else if (temp < k) {
                first++;

            } else last--;
        }

        return pairs.size();
    }

    public static List<String> CountPaths(List<String> paths) {
        List<String> totResult = new ArrayList<>();


        for (String path : paths) {
            String[] coord = path.split(" ");

            int x = Integer.parseInt(coord[0]);
            int y = Integer.parseInt(coord[1]);
//            System.out.println(x+" "+y);
            int[][] matrix = new int[x + 1][y + 1];
            Set<List<Integer>> seen = new HashSet<>();
            List<String> result = new ArrayList<>();
            dfs(matrix, result, new StringBuilder(), 0, 0, new HashSet<>(), x, y);
            Collections.sort(result, (a, b) -> a.compareTo(b));
            System.out.println(result);

        }


        return totResult;
    }

    public static void dfs(int[][] matrix, List<String> result, StringBuilder currList, int currX, int currY, Set<List<Integer>> seen, int tx, int ty) {
        if (currX == tx && currY == ty) {
            System.out.println("here");
            String temp = currList.toString();
            System.out.println(temp);
            result.add(currList.toString());
            return;
        }

        for (int[] dir : dirs) {
            int newX = currX + dir[0];
            int newY = currY + dir[1];

            if (newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[0].length && !seen.contains(Arrays.asList(newX, newY))) {
                char ch = '\0';
                if (dir[0] == 1) {
                    ch = 'V';
                } else ch = 'H';

                seen.add(Arrays.asList(newX, newY));
                currList.append(ch);

                dfs(matrix, result, currList, newX, newY, seen, tx, ty);

                if (currList.length() > 0) currList.deleteCharAt(currList.length() - 1);
                seen.remove(Arrays.asList(newX, newY));
            }
        }

    }

    public static void main(String[] args) {
        Set<List<Integer>> seen = new HashSet<>();

        String path = "1 1 3";
        List<String> paths = new ArrayList<>();
        paths.add(path);
        System.out.println(CountPaths(paths));


        HashSet<int[]> set = new HashSet<>(
        );

        set.add(new int[]{1, 2});
        set.add(new int[]{1, 2});

        System.out.println(set);

    }
}
