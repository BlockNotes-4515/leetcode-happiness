class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //Sorting an array items in an array
        int n=nums.length;
        Arrays.sort(nums);

        /*
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }*/

        //Now we simply return the kth largest element in an array
        return nums[nums.length-k];
    }
}