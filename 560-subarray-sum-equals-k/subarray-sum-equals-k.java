class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n=nums.length;
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int count=0;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=prefix[j+1]-prefix[i];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}