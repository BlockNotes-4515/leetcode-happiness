class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        int n=nums.length;
        int left=0;
        long sum=0;
        int count=0;

        //Sort the Arrays
        Arrays.sort(nums);

        for(int right=0;right<n;right++){

            sum+=nums[right];

            while((long)nums[right]*(right-left+1)-sum>k){
                sum-=nums[left];
                left++;
            }
            count=Math.max(count,right-left+1);
        }
        return count;
    }
}