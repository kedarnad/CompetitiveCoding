public class BitImpOperations {

    static boolean getBit(int num, int i) {
        System.out.println(" Get Bit : " + (num & (1 << i)));
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        System.out.println(" (1<<i)) " + (1 << i));
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {

        int mask = ~(1 << i);

        System.out.println("~(1<<i) " + mask);

        return num & mask;
    }

    static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        System.out.println("(1<<i)-1 -> " + mask);
        return num & mask;
    }

    static int clearBitsThrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        System.out.println(" (-1<<(i+1)) " + mask);
        return num & mask;
    }

    static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }


    public static void main(String[] args) {
        System.out.println("Get Bit Opr -> 7, 2 ->" + getBit(7, 2));

        System.out.println("Set Bit Opr -> 7, 2 ->" + setBit(7, 2));

        System.out.println("Clear Bit Opr -> 7, 2 ->" + clearBit(7, 2));

        System.out.println("Clear bits through MSB ->" + clearBitsMSBthroughI(15, 2));

        System.out.println("Clear Bits Through 0 -> " + clearBitsThrough0(15, 2));

        System.out.println("update bit " + updateBit(8, 1, true));


    }
}
