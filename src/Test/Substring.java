package Test;

import java.util.HashMap;
import java.util.Iterator;

public class Substring {

    static boolean isvalid(StringBuilder str, int num) {

        HashMap<Character, Integer> hs = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!hs.containsKey(str.charAt(i)))
                hs.put(str.charAt(i), 0);
        }

        int tempcount = 0;
        Iterator<Character> itr = hs.keySet().iterator();
        while (itr.hasNext()) {
            itr.next();
            tempcount++;
        }

        return tempcount == num;
    }

    static int countKDistinctSubstrings(String inputString, int num) {

        int countUnique = 0;
        StringBuilder temp = new StringBuilder();
//        for(int i=0; i <inputString.length(); i++){
//            temp= new StringBuilder();
//            for(int j =0; j <i; j++){
//                temp.append(inputString.charAt(j));
//            }
//            if(isvalid(temp, num)){
//                countUnique++;
//            }
//        }

        for (int i = 0; i < inputString.length(); i++) {
            temp = new StringBuilder();
            for (int j = i + 1; j <= inputString.length(); j++) {
                String str = inputString.substring(i, j);
                temp.append(str);
//                System.out.println(inputString.substring(i, j));

                if (isvalid(temp, num)) {
                    countUnique++;
                }

            }


            // Please refer below article for details
            // of substr in Java
            // https://www.geeksforgeeks.org/java-lang-string-substring-java/
//                System.out.println(str.substring(i, j));
        }

        return countUnique;
    }


    public static void main(String args[]) {
        System.out.println(countKDistinctSubstrings("pqpqs", 2));
    }
}
