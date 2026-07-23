class Solution {
    public boolean check(int[] nums) {
        
        //First Approach
        /*
        int n=nums.length-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    return false;
                }
            }
        }
        return true;*/
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count=count+1;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}