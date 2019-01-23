public class CountAndSay {

    public static void main(String args[]) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        int i = 1;


        return helperFunction(i + "", 1, n);
    }

    public String helperFunction(String str, int count, int n) {

//        String newStr ="";
//        if(count!=n){
//            int no_ofDigits=1;
//            char[] tempStr=str.toCharArray();
//
//            for(int i=1; i <tempStr.length; i++){
//                no_ofDigits=1;
//                while(tempStr[i]==tempStr[i-1]){
//
//
//                        if(tempStr[i]==tempStr[i-1])
//                     no_ofDigits++;
//
//
//                    i++;
//
//                }
//                if(tempStr[i]!=tempStr[i-1])
//                {
//                    newStr=newStr+no_ofDigits+tempStr[i-1];
//                }
//
//                if(tempStr[i]!=tempStr[i-1] && i==tempStr.length-1)
//                    newStr=newStr+1+tempStr[i];
//
//
//            }
//
//            count++;
//        }
//
//        if(count==n)
//            return newStr;
//        else
//            return helperFunction(newStr, count, n);


        if (n == 1) {
            return "1";
        }
        if (count < n) {
            String newStr = "";
            char[] tempStr = str.toCharArray();

            if (tempStr.length == 1) {
                newStr = newStr + 1 + tempStr[0];

//            str=newStr;
            } else {
                for (int i = 1; i < tempStr.length; i++) {
                    int no_of_digs = 1;

                    while (tempStr[i] == tempStr[i - 1]) {
                        no_of_digs++;
                        i++;
                    }

                    if (tempStr[i] != tempStr[i - 1] && i == tempStr.length - 1)
                        newStr = newStr + 1 + tempStr[i];

                    if (tempStr[i] != tempStr[i - 1]) {
                        newStr = newStr + no_of_digs + tempStr[i - 1];
                    }


                }
            }

//           return str;
            count++;
            str = newStr;
            return helperFunction(str, count, n);
        } else

            return str;
    }

}
