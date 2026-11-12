class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n=nums.length;
        int maxSum=nums[0];
        int minSum=nums[0];
        int minAns=nums[0];
        int ans=nums[0];
        int sum=nums[0];

        for(int i=1;i<n;i++){

            int v1=nums[i];
            int v2=maxSum+nums[i];
            int v3=minSum+nums[i];

            //Calculating the maxSum and minSum
            maxSum=Math.max(v1,v2);
            minSum=Math.min(v1,v3);

            //Calculating it's sum now
            sum=sum+nums[i];

            //Calculating the final ans values result here
            ans=Math.max(ans,maxSum);
            minAns=Math.min(minAns,minSum);
        }
        if(ans>0){
            ans=Math.max(ans,sum-minAns);
        }
        return ans;
    }
}