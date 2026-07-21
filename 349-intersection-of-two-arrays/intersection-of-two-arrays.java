class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> s1=new HashSet<>();
        HashSet<Integer> s2=new HashSet<>();

        for(int num:nums1){
            s1.add(num);
        }
        for(int num: nums2){
            s2.add(num);
        }
        //Making the resultset.
        int res[]=new int[s1.size()];
        int k=0;
        for(int num: s1){
            if(s2.contains(num)){
                res[k]=num;
                k=k+1;
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }
}