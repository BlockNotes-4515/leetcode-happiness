class Solution {
    public int rob(int[] nums) {
        /*
        int n=nums.length;
        int sum1=0;
        int sum2=0;
        int max=0;

        if(n==1){
            return nums[0];
        }
        
        for(int i=0;i<n;i++){
            if(i%2==0){
                sum1+=nums[i];
            }else{
                sum2+=nums[i];
            }
        }
        max=Math.max(sum1,sum2);
        return max;
        */
        int n=nums.length;
        int prev1=0;
        int prev2=0;
        
        for(int i=0;i<n;i++){
            int curr=Math.max(prev1,prev2+nums[i]);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}