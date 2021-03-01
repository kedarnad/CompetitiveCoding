public class TrialTemp {


    public static void main(String[] args) {

        TrialTemp tmp = new TrialTemp();
        Integer temp = new Integer(6);
        temp = tmp.modify(temp);

        System.out.println(temp);

        int h = 8;

        h = tmp.modifyPrimitive(h);
        System.out.println(h);
    }

    public int modifyPrimitive(int temp) {
        temp = 9;
        return temp;

    }

    public Integer modify(Integer tmp) {
        tmp = new Integer(7);
        return tmp;
    }

    public void modifyArray(int[] arr) {


    }
}
