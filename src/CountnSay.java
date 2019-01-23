import java.lang.*;
class Solution {
    public String countAndSay(int n) {
       
        int temp=1;
       boolean flag=false;
        for(int i=0;i<n-1;i++)
        {  System.out.println("new");
             ArrayList<Integer> a=new ArrayList<Integer>();
              ArrayList<Integer> b=new ArrayList<Integer>();
            
            while(temp>0)
            {
                int x=temp%10;
                a.add(x);
                    temp=temp/10;
            }
             System.out.println(a);
            int count=0;
            for(int j=0;j<a.size();j++)
            {
               System.out.println("poop2");
                flag=false;
                if(a.size()==1)
                {
                    b.add(1);
                    b.add(1);
                   // System.out.println(b);
                    flag=true;
                }
                int h=-1;
                if(flag==false)
                {
                      System.out.println("poop");
                   count=0;
               int g=a.get(j);
                    System.out.println(a.size());
                        System.out.println((j+1)<a.size());
                    while(a.get(j)==g)
                    {
                         System.out.println("fff");
                         count++;
                        if((j+1)<a.size())
                        j++;
                        else
                        {
                           
                            break;
                            
                        }
                       
                    }
                    h=g;
                     System.out.println(g +"gg"+count);
                    b.add(g);
                    b.add(count);
                    
            }
                
                 System.out.println("poop1");
                 System.out.println(j);
                if(j+1==a.size() && a.get(j)!=h)
                {
                    b.add(a.get(j));
                    b.add(1);
                }
            }
        
          for(int k=1;k<b.size();k++)
          {
            temp=0;
              temp=temp+(int)(b.get(k)*Math.pow(10,k));
           
          }
            temp=temp+b.get(0);
                System.out.println(temp);
            
        }
        // System.out.println(b);
       String listString="SS";
    
        return listString;
    }
}
