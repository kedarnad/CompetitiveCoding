import java.util.*;

public class WeightedString {
    public static Map<String, Long> populateMap() {
        Map<String, Long> map = new HashMap<>();
        map.put("A", (long) 1);

        long counter = 1;
        for (int i = 66; i < 91 - 8; i++) {
            long item = map.get(String.valueOf((char) (i - 1)));
            map.put(String.valueOf((char) i), ++counter * item + item);
        }
        return map;
    }

    public static Map<Long, String> popMap() {
        Map<Long, String> map = new HashMap<>();
        map.put((long) 1, "A");
        long count = 1, item = 1;
        for (int i = 66; i < 91 - 8; i++) {
            long new_val = ++count * item + item;
            map.put(new_val, String.valueOf((char) i));
            item = new_val;
        }

        return map;
    }

    public static String weightString(int weight) {

        long[] weights = new long[18];
        Map<Long, String> map = popMap();
        int i = 0;
        for (long x : map.keySet()) {
            weights[i++] = x;
        }
        Arrays.sort(weights);

        List<String> list = new ArrayList<>();
        dfs(weight, 0, list, map, weights, new StringBuilder());

        if (list.size() == 0)
            return "";
        String min = list.get(0);
        for (String itr : list) {
            if (min.length() > itr.length())
                min = itr;
        }

        return min;
    }


    public static void dfs(long weight, int index, List<String> list, Map<Long, String> map, long[] weights, StringBuilder strB) {
        if (weight == 0) {
            list.add(new String(strB));
            return;
        } else if (weight < 0) {
            return;
        }


//        if(weight >0 && index<weights.length){
//            long new_w= weights[index];
//            strB.append(map.get(new_w));
//            dfs(weight-new_w, index, list, map, weights, strB);
//            strB.deleteCharAt(strB.length()-1);
//            if(index<weights.length-1){
//                index++;
//                strB.append(map.get(weights[index]));
//                dfs(weight- weights[index], index, list, map, weights, strB);
//            }
//
//        }

        for (int i = index; i < weights.length; i++) {
            long new_w = weights[i];
            strB.append(map.get(weights[i]));
            dfs(weight - new_w, i, list, map, weights, strB);
            strB.deleteCharAt(strB.length() - 1);
        }
    }

    public static void main(String args[]) {

        System.out.println(String.valueOf((char) 65));
//        System.out.println(popMap());
        System.out.println(weightString(20));
    }
}
