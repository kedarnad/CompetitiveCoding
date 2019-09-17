package leetcodeContest;

import java.util.HashMap;


public class Dominos {

    HashMap<String, Integer> map = new HashMap<>();
    int count = 0;

    public static void main(String[] args) {

        int[][] dominos = {{1, 2}, {1, 2}, {2, 1}, {2, 1}, {3, 4}, {4, 3}, {5, 6}};
        System.out.println(new Dominos().numEquivDominoPairs(dominos));

//        System.out.println(new Dominos().combination(1,2));


    }

    int factorial(int n) {
        if (n == 1) return 1;

        else if (n == 0) return 1;

        else return n * factorial(n - 1);

    }

    public int combination(int n, int r) {

        int result = factorial(n) / (factorial(n - r) * factorial(r));


        return result;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            String one, two;
            int n;
            one = dominoes[i][0] + "," + dominoes[i][1];
            two = dominoes[i][1] + "," + dominoes[i][0];

            if (map.containsKey(one)) {
                n = map.get(one);
                count += n;
                map.replace(one, n + 1);
            } else if (map.containsKey(two)) {
                n = map.get(two);
                count += n;
                map.replace(two, n + 1);
            } else {
                map.put(one, 1);
            }


        }
//        for(int i: map.values()){
//            if(i==1) continue;
//            else
//            count+=combination(i, 2);
//        }
        return count;
    }

}
