class Solution {
    public int search(int[] nums, int target) {

        /*Normal binary search in sorted manner
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
        */
        //Solving for rotated sorted array using binary search 
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }
            //Searching in the 'right' portion of an sorted array
            else if(nums[mid]<=nums[right]){
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            //Searching in the 'left' portion of an sorted array
            else{
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }  
        return -1;
    }
}