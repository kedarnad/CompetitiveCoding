//class Solution {
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//       //HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
//  ArrayList<Integer> x=new ArrayList<Integer>();
// if(nums.length==0)
//     return x;
//  List l=Arrays.asList(nums);
//        System.out.println(l.get(0));
//          System.out.println(l.get(0));
//       // l=Arrays.asList(nums);
//      //  for (int f : nums) l.add(f);
//        int g=nums.length;
//      //  int j=0;
//        for(int i=0;i<=nums.length/2;i++)
//        {
//            int k=g-i;
//            if(!l.contains(i) && i!=0 && !x.contains(i))
//            {
//                x.add(i);
//                // j++;
//            }
//            if(!l.contains(k) && !x.contains(k))
//            {
//               x.add(k);
//                //j++;
//            }
//        }
//        if(!l.contains(g) && !x.contains(g))
//        {
//            x.add(g);
//        }
//        return x;
//    }
//}
