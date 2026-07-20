class Solution {
    public int singleNumber(int[] nums) {
        
        //[2,2,1]
        // Ans. 1
        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}