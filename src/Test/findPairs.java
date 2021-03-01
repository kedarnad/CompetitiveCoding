package Test;

import java.util.*;

class Pairs {
    int one;
    int two;

    Pairs(int one, int two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, two);

    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pairs)) {
            return false;
        }

        Pairs otherPair = (Pairs) other;
        return (this.one == otherPair.one && this.two == otherPair.two) || (this.one == otherPair.two && this.two == otherPair.one);
    }

    @Override
    public String toString() {
        return this.one + ":" + this.two;
    }
}

public class findPairs {


    public static int finddistPairs(int[] arr, int k) {
        Set<Pairs> pairs = new HashSet<>();
        Set<Integer> nums = new HashSet<>();

        for (int i : arr) {
            if (nums.contains(i + k)) {
                int a1 = i;
                int a2 = i + k;
                pairs.add(new Pairs(a2, a1));
            } else if (nums.contains(i - k)) {
                int a1 = i - k;
                int a2 = i;
                pairs.add(new Pairs(a2, a1));

            }
            nums.add(i);

        }
        System.out.println(pairs);

        return pairs.size();
    }


    public static String alphaMax(String str) {


        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });


        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i; j <= str.length() - 1; j++) {
                pq.add(str.substring(i, j + 1));

            }
        }

        System.out.println(pq.toString());

        return pq.poll();
    }


    public static void main(String[] args) {

        Set<Pairs> pairs_dist = new HashSet<>();

        pairs_dist.add(new Pairs(1, 2));
        pairs_dist.add(new Pairs(1, 2));

//        System.out.println(pairs_dist);

        System.out.println(finddistPairs(new int[]{1, 1, 1, 2, 3}, 1));

        System.out.println(alphaMax("baca"));

    }
}
