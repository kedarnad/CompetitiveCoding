import java.util.ArrayList;
import java.util.List;

public class FindingSubstrings {

    public static void main(String[] args) {
        System.out.println(new FindingSubstrings().findSubstrings("ABBCZBAC"));
    }

    public int findSubstrings(String str) {
        List<String> result = new ArrayList<>();
        int start = 0;
//        int mid=1;
        int end = 2;
        boolean flag = true;

        if (str.length() <= 2)
            return result.size();

        while (end - start >= 2) {
            if (str.substring(start, end).matches(".*A.*")
                    && str.substring(start, end).matches(".*B.*")
                    && str.substring(start, end).matches(".*C.*") && end <= str.length()) {
                if (end >= str.length()) {
                    result.add(str.substring(start, end));
                    if (start <= end - 2)
                        start++;

                    if (end - start <= 2)
                        break;
                } else {
                    result.add(str.substring(start, end));
                    end++;
                    flag = false;
                }
            }
            if (flag && end < str.length()) {
                end++;
            }
        }
        return result.size();
    }

}
