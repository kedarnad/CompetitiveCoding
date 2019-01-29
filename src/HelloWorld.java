public class HelloWorld {

    private static boolean equalityTest3(String a, String b) {
        return System.identityHashCode(a) == System.identityHashCode(b);
    }

    private static boolean equalityTest4(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return true;
        } else {
            if (a.length() == 0 || b.length() == 0) {
                return false;
            }
            if (a.charAt(0) == b.charAt(0)) {
                return equalityTest4(a.substring(1), b.substring(1));
            } else {
                return false;
            }
        }
    }


    public static void main(String args[]) {
        System.out.println("Hello World!!!");


        String abcV1 = "abc";
        String abcV2 = "a" + "b" + "c";
        String abcV3 = "abcd".substring(0, abcV1.length());
        System.out.println(abcV3);
        String abcV4 = "" + abcV2;
        String abcV5 = "a" + (char) 98 + 99;
        String abcV6 = new String("abc");
        String abcV7 = abcV3.intern();
        String abcv8 = abcV6;
        System.out.println(abcV3 == abcV1);
        System.out.println(abcV3);


//        System.out.println(equalityTest3(abcV1, abcV4));

        System.out.println(equalityTest4(abcV1, abcV7));

        System.out.println(abcV1.charAt(0) == abcV3.charAt(0));


    }
}
