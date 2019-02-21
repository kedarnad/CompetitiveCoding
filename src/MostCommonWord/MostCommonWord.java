package MostCommonWord;

import java.util.Arrays;
import java.util.HashMap;

public class MostCommonWord {

    public static void main(String args[]) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

//        System.out.println(Arrays.asList(words));
        String[] banned = {"hit"};

        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hs = new HashMap<>();

        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        for (String str : words) {
            if (!Arrays.asList(banned).contains(str)) {

                if (!hs.containsKey(str))
                    hs.put(str, 1);
                else {
//                    int val=(int)hs.get(str);
                    hs.put(str, hs.get(str) + 1);
                }
            }
        }

        int max = 0;
        String tempString = "";

        for (String temp : hs.keySet()) {

            if (hs.get(temp) > max) {
                tempString = temp;
                max = hs.get(temp);
            }

        }

        return tempString;
    }
}
