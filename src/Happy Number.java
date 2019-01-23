import java.util.ArrayList;

class Solution {
    public static boolean isHappy(int n) {
        int temp=n;
        ArrayList<Integer> a  = new ArrayList<Integer>();
             int sum=0;
        while(true)
        {
         
            if(temp!=n)
                temp=sum;
            sum=0; 
       while(temp>0)
       {
           sum=sum+ (int)Math.pow(temp%10,2);
          //a.add(temp%10);
          temp=temp/10;
           
       }
           
            
        if(sum==1)
        return true;
            else
                if(a.contains(sum))
                    return false;
             a.add(sum);
        }
        
    }

}
