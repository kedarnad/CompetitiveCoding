package TejasDataCore;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class CompressionTech {

    public static HashMap<Character, Long> fillhash(HashMap<Character, Long> hs, long i) {

        if (i == 65)
            hs.put('A', ((long) 1));
        else
            hs.put((char) i, (i - 64) * hs.get((char) (i - 1)) + (i - 64));

        return hs;
    }
//    public static SortedMap<Character, Long> fillhash(SortedMap<String, Long> hs, long i){
//
//        if(i==65)
//            hs.put("A", ((long) 1));
//        else
//            hs.put((String)i, (i-64)*hs.get((char)(i-1))+(i-64));
//
//        return hs;
//    }

    public static String findweight(long wt) {
        HashMap<Character, Long> hs = new HashMap<>();
        SortedMap<String, Long> tm = new TreeMap<>();
        hs.put('A', (long) 1);

        for (int i = 65; i < (65 + 20); i++) {
            hs = fillhash(hs, i);
//           tm =fillhash(tm,i);
        }

//        System.out.println(((TreeMap<Character, Long>) tm).ceilingEntry("BBBBB"));


//        HashMap<Long, Character> newhs = new HashMap<>();
//        System.out.println(hs);
//
//        for(Character i: hs.keySet()){
//            newhs.put(hs.get(i), i);
//        }
//        System.out.println(newhs);


        return "";
    }

    public static void main(String[] args) {
        System.out.println(((int) 'A') - 64);

        System.out.println((char) 66);

//        for(int i=65; i <(65+26); i++){
//            System.out.print(i);
//        }

        findweight(70);


    }
}
