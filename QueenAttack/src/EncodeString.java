public class EncodeString {
    public static void main(String[] args) {
        String str = "";
        str += "#u#";

        String[] strs = str.split("#u#");

//        for(String str1: strs){
//            System.out.print(str1);
//        }

        System.out.println(Character.toString((char) 257));
    }
}
