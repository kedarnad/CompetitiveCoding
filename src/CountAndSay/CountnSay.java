package CountAndSay;

import java.util.ArrayList;

class Solution {
    public String countAndSay(int n) {
       
        long temp=1;
   ArrayList<Long> b=null;
        if(n==1)
        {
            return "1";
        }
        for(int i=0;i<n-1;i++)
        {  
        
             ArrayList<Long> a=new ArrayList<Long>();
              b=new ArrayList<Long>();
            
            while(temp>0)
            {
                long x=temp%10;
                a.add(x);
                    temp=temp/10;
            }
           
                        int j=0;
         while(j<a.size())
         {
             long count=0;
             long temp1=a.get(j);
             while(j<a.size()&& temp1==a.get(j))
             {
                 count++;
                 j++;
             }
             
       
             b.add(count);
             b.add(temp1);
                    
         }
                
            
             
        
       // int temp=0;
          for(int k=0;k<b.size();k++)
                 {
                     temp=temp+(long)(b.get(k)*Math.pow(10,k));
                 }
            
               
            
        }
        
      StringBuilder s=new StringBuilder();
       
         for(int j=0;j<b.size();j++)
         {
             s.append(b.get(j));
         }
        return s.toString();
    }
}
