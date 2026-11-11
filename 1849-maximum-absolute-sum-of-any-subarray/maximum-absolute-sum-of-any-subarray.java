class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int n=nums.length;
        int maxSum=nums[0];
        int minSum=nums[0];
        int ans=Math.abs(nums[0]);

        for(int i=1;i<n;i++){

            int v1=nums[i];
            int v2=maxSum+nums[i];
            int v3=minSum+nums[i];

            maxSum=Math.max(v1,Math.max(v2,v3));
            minSum=Math.min(v1,Math.min(v2,v3));

            int a=Math.abs(maxSum);
            int b=Math.abs(minSum);

            ans=Math.max(ans,Math.max(a,b));
        }
        return ans;
    }
}