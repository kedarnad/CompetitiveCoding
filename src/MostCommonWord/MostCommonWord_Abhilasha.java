import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lower=paragraph.toLowerCase();
        //String[] w=lower.split(" ");
         String[] w = lower.replaceAll("[^a-zA-z]"," ").toLowerCase().trim().split("\\s+");
        HashMap<String,Integer> s=new HashMap<String,Integer>();
        int max=0;
        String maxstr="";
        ArrayList<String> cv=new ArrayList<String>();
        for(int i=0;i<w.length;i++)
        {
         /*  if(w[i].split(",").length>1)
            {
                //System.out.println(w[i].split(",").length);
                int p=w.length;
                int l=0;
                while(l<w[i].split(",").length)
                {
                    cv.add(w[i].split(",")[l]);
                    l++;
                    p++;
                } 
               System.out.println(cv);
        
            }*/
            if(w[i].indexOf(",")!=-1 || w[i].indexOf(".")!=-1 || w[i].indexOf("!")!=-1)
                w[i]=w[i].substring(0,w[i].length()-1);
            if(s.containsKey(w[i]))
            {
                s.put(w[i],s.get(w[i])+1);
                if(s.get(w[i])+1>max && !Arrays.asList(banned).contains(w[i]))
                {
                    max=s.get(w[i])+1;
                    maxstr=w[i];
                }
            }
            else
            {
                s.put(w[i],1);
               if(max<1 && !Arrays.asList(banned).contains(w[i]))
               {
                   max=1;
                   maxstr=w[i];
               }
            }
        }
        if(s.size()==1)
            return w[0];
        return maxstr;
        
    }
}
