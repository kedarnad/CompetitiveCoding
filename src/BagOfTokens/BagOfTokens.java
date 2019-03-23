class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int gain=0;
        Arrays.sort(tokens);
        int j=tokens.length-1;
        int i=0;
       int max=0;
      //  for(int i=0;i<tokens.length;i++)
            while(i<=j)
        {
            if(tokens[i]<=P)
            {
               P=P-tokens[i];
                //tokens[i]=0;
                gain++;
                i++;
               if(max<gain)
                   max=gain;
            }
            else if(gain>0)
            {
              P=P+tokens[j];
                gain--;
       
                  j--;
            }
                else
                    break;
            
        }
        return max;
    }
}
