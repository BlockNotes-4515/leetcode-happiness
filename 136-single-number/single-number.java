class Solution {
    public int singleNumber(int[] nums) {
        
        //[2,2,1]
        // Ans. 1
        int n=nums.length;
        int result=0;
        for(int i=0;i<n;i++){
            result^=nums[i];
        }
        return result;
    }
}