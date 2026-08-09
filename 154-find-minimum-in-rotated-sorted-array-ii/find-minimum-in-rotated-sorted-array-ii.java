class Solution {
    public int findMin(int[] nums) {
        
        int left=0;
        int right=nums.length-1;
        while(left<right){
            // (i) Finding mid : int mid=(left+right)/2;
            //Most Optimal approach
            int mid=left+(right-left)/2;

            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else if(nums[mid]<nums[right]){
                right=mid;
            }
            else{
                right--;
            }
        }
        return nums[left];
    }
}