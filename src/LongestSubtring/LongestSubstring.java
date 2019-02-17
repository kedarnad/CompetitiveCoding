class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      char[] ab=s.toCharArray();
       List<Character> a = new ArrayList<Character>();
for(char c : ab) {
    a.add(c);
}
      //  List<Character> a=Arrays.asList(abc);
        ArrayList<Character> b=new ArrayList<Character>();
        //char[] b=new Char[a.size()];
        
        int count=0;
        StringBuilder sb=new StringBuilder();
        if(a.size()==1)
            return 1;
        int flag=0;
        for(int i=0;i<a.size();i++)
        {
          /*  if(map.containsKey(a[i]))
            {
               count= map.get(a[i])+1;
                map.put(a[i],count);
            }
            else
                map.put(a[i],1); */
           // System.out.println(count+"pp"+i+sb);
            if(sb.indexOf(a.get(i).toString())!=-1)
            {
               // i=map.get(a.get(i));
                if(count< sb.length())
                    count=sb.length();
              
              
                sb=new StringBuilder();
                 for(int j=map.get(a.get(i))+1;j<=i;j++) 
                         sb.append(a.get(j));
              flag=1;
                 if(map.containsKey(a.get(i)))
                { 
                    map.remove(a.get(i));
                    map.put(a.get(i),i);
                    // System.out.println(map);
                    // System.out.println("dsds");
                } 
            }
            else
            {
               
                    map.put(a.get(i),i);
                                 // System.out.println(map);

                b.add(a.get(i));
                sb.append(a.get(i));
                //  System.out.println(sb);
            }
        }
         //System.out.println(count+"aaa");
       /* if(count< sb.length())
        {
                    count=sb.length();
                System.out.println(count+"aaa");
        } */
    if(flag==0)
        return sb.length();
           // System.out.println(count+"SDSd");
        return count;
       
    }
}
