class Solution {
    public int dominantIndex(int[] nums) {
        
        int n=nums.length;
        int max1=-1;
        int indx=-1;
        int max2=-1;
        for(int i=0;i<n;i++){
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                indx=i;
            }
            else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        if(max1>=(2*max2)){
            return indx;
        }
        return -1;
    }
}