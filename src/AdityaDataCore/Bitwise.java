package AdityaDataCore;

public class Bitwise {

    public static void main(String[] args) {


        System.out.println(new Bitwise().isUnique("bcd"));

        System.out.println(1 << ('d' - 'a'));

        System.out.println((int) 'd');
        System.out.println((int) 'a');
        System.out.println(1 << 2);

    }

    public void checkBitWise() {
        int x = 20;
        System.out.println(x << 1);
        System.out.println(x << 1);
    }

    public boolean isUnique(String str) {

        int checker = 0;

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i) - 'a';
//            System.out.println((checker & (1<<val)));
            System.out.println(i + " " + (1 << val));
            System.out.println(i + " " + val);
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }
}
