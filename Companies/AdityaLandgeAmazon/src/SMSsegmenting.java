import java.util.ArrayList;
import java.util.List;

public class SMSsegmenting {
    public static List<String> segment(String sentence) {
        List<String> res = new ArrayList<>();

        int e = 0;
        int s = 0;
        while (s < sentence.length() && e < sentence.length()) {
            e = (s + 155 < sentence.length()) ? s + 155 : sentence.length();
            String temp = sentence.substring(s, e);
            res.add(temp);
            s = e;
        }


        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) + "(" + (i + 1) + "/" + res.size() + ")");
        }

        for (String str : res)
            System.out.print(str.length() + " ");

        return res;
    }

    public static List<String> segment2(String sentence) {
        List<String> res = new ArrayList<>();
        String[] words = sentence.split(" ");
        int index = 0;
        while (index < words.length) {
            int c = 0;
            while (index < words.length && c < 155) {
                c += words[index].length();

                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(segment("njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg"));

    }
}
