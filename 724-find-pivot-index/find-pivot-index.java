class Solution {
    public int pivotIndex(int[] nums) {
        
        int n=nums.length;

        //Calculating the compelete rightSum of an array
        int rightSum=0;
        for(int i=0;i<n;i++){
            rightSum=rightSum+nums[i];
        }

        //Checking finding the pivot index 
        int leftSum=0;
        for(int i=0;i<n;i++){
            if(leftSum==rightSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
            rightSum-=nums[i];
        }
        return -1;
    }
}