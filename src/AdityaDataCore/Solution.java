package AdityaDataCore;

import java.util.*;

class smallestString {
    public static void main(String[] args) {
        SortedMap<Character, Integer> tm = new TreeMap<>();
        SortedMap<Integer, Character> tmRev = new TreeMap<>();
        char c;
        int count = 2;
        int value = 1;
        int V = 20;
        tm.put('A', value);
        tmRev.put(value, 'A');
        for (c = 'B'; c <= 'K'; ++c) {
            char x = c;
            value = count + count * tm.get(--x);
            tm.put(c, value);
            tmRev.put(value, c);
            count++;
        }

        ArrayList<Integer> values = new ArrayList<>(tm.values());
        Set<Integer> output = new HashSet<>();
//        output = minCoins(values, values.size(), V);
//        countCurrency(V, values);
//        System.out.println(output);
//        ArrayList<Character> out = new ArrayList<>();
//        for (int val: output){
//            System.out.println(val);
//            out.add( tmRev.get(val) );
//        }
//        String op="";
//        for(char c2: out){
//            op += c2;
//        }
//        System.out.println(op);

        System.out.println(new smallestString().minCoinDynamic(3945636, values));

//        System.out.println('I'-64);
    }

    static Set<Integer> minCoins(ArrayList<Integer> values, int m, int V) {
        Set<Integer> output = new HashSet<>();
        int table[] = new int[V + 1];
        table[0] = 0;
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++)
                if (values.get(j) <= i) {
                    int sub_res = table[i - values.get(j)];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                        output.add(values.get(j));
                    }

                }

        }
        return output;

    }

    public static void countCurrency(int amount, ArrayList<Integer> values) {
        int[] notes = new int[]{2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int[] noteCounter = new int[values.size()];

        // count notes using Greedy approach
        for (int i = 0; i < values.size(); i++) {
            if (amount >= values.get(i)) {
                noteCounter[i] = amount / values.get(i);
                amount = amount - noteCounter[i] * values.get(i);
            }
        }

        // Print notes
        System.out.println("Currency Count ->");
        for (int i = 0; i < 9; i++) {
            if (noteCounter[i] != 0) {

                System.out.println(values.get(i) + " : "
                        + noteCounter[i]);
            }
        }
    }


    public int minCoinDynamic(int amount, ArrayList<Integer> values) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.

        HashMap<Integer, Integer> hs = new HashMap<>();
        int[] coinReq = new int[amount + 1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < values.size(); j++) {
                if (values.get(j) <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - values.get(j)] + 1, coinReq[amt]);
                    hs.put(amt, values.get(j));
                }
            }
        }
        //return the optimal solution for amount
        System.out.println(hs.get(amount));
        return coinReq[amount];

    }
}

