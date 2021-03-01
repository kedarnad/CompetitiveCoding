import java.util.ArrayList;
import java.util.List;

public class ComputeNoScore {

    public static int compute_number_score(int number) {
        int sum = 0;
        String num = String.valueOf(number);
//
//        //computing 9
//        for(int i=0; i<num.length(); i++){
//
//            if(num.charAt(i) =='9'){
//                sum+=4;
//            }
//        }
//
//        //computing ones
//        boolean flag=false;
//        for(int i=0; i<num.length(); i++){
//
//            if(num.charAt(i)=='1' && flag){
//                sum+=5;
//                flag=true;
//            }
//        }
//
//
//        //computing evens
//        for(int i=0; i<num.length(); i++){
//            if((int)num.charAt(i) %2 ==0)
//            sum+=2;
//        }
//
//        if(number%7==0) sum+=1;

        //handling sequences
//        List<Integer> list = new LinkedList<>();
//        int i=0;
//        int count=0;
//        while(i<num.length()-1){
//
//           if(i<num.length()&&(int)num.charAt(i+1) == (int)num.charAt(i)+1){
//               while(i<num.length() && (int)num.charAt(i+1) == (int)num.charAt(i)+1)
//               { count++;
//                    i++;
//
//               }
//               list.add(count+1);
//               count=0;
//           }
//           else {
//               i++;
//               count+=1;
//               list.add(count);
//                count=0;
//           }
//        }
//
//        for(int j: list){
//            sum+=j^2;
//        }

        return get(number);

    }

    public static int get(int num) {
        int x = 0, count = 1;
        List<Integer> store = new ArrayList<>();
        String s = Integer.toString(num);
        while (x < s.length() - 1) {
            if (s.charAt(x) == s.charAt(x + 1) + 1) {
                count++;
                x++;
            } else {
                x++;
                store.add(count);
                count = 1;
            }
        }
        store.add(count);
        int score = 0;
        for (Integer i : store) {
            score += i * i;
        }
        return score;
    }


    public static void main(String[] args) {
        System.out.println(compute_number_score(9678562));
    }
}
