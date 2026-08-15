class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //Creating the HashMap of nums2 and store the elements and find greater
        //After getting the Greater elements
        //We traverse nums1 and get data values

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums2.length;i++){

            int greater=-1;
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    greater=nums2[j];
                    break;
                }
            }
            map.put(nums2[i],greater);
        }
        //Comparing it with the nums1 array
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}