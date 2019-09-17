package PermutationOfAPalindrome;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfPalindrome {
    public static boolean isPermutPalindrome(String phrase) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : phrase.toCharArray()) {
            if (c == ' ') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i : map.values()) {
//            if(i==' ')continue;
            if (i % 2 == 1) {
                if (count == 1) return false;
                else {
                    count++;
                }
            }
        }
        return count <= 1;
    }
//*************************Different Approach *****************************//
//     //Another method for checking the permutation of the palindromes

    public static boolean isPermutationPalindromeBitwise(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || check4OneBit(bitVector);
    }

    public static void printBinary(int Num) {
        int[] binaryNum = new int[1000];
        int i = 0;
        int temp = Num;
        while (Num > 0) {
            binaryNum[i] = Num % 2;
            Num /= 2;
            i++;
        }

        System.out.println(" \n Binary Format: " + temp);
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binaryNum[j]);
        }
    }

    private static boolean check4OneBit(int bitVector) {
        return (bitVector & bitVector - 1) == 0;
    }

    public static int createBitVector(String phrase) {
        int bitVector = 0;

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
            printBinary(bitVector);
        }

        return bitVector;
    }


    public static int toggle(int bitVector, int index) {

        if (index < 0) return bitVector;

        int mask = 1 << index;

        if ((bitVector & mask) == 0)
            bitVector |= mask;
        else
            bitVector &= ~mask;

        return bitVector;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int b = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= b) {
            return val - a;
        }
        return -1;
    }


    public static void main(String[] args) {
        String phase = "bctdhhdtcb";
        System.out.println(isPermutPalindrome(phase));
        Map<Character, Integer> map = new HashMap<>();

        for (char c : phase.toCharArray()) {
            if (c == ' ') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);


        System.out.println(isPermutationPalindromeBitwise(phase));

//        int mask=2;
//        System.out.println();

        printBinary(-3);
    }


}
