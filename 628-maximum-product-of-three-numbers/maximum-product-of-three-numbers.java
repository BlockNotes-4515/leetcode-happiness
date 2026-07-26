class Solution {
    public int maximumProduct(int[] nums) {

        //Time Limit Exceeded by this solution because it's complex and takes lot's of time to run.
        /*
        int n=nums.length;
        int max_prod=Integer.MIN_VALUE;
        
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int prod=nums[i]*nums[j]*nums[k];
                    max_prod=Math.max(max_prod,prod);
                }
            }
        }
        return max_prod;
        */

        //This is our dynamic approach make it more simple and run in an ms
        Arrays.sort(nums);
        int n=nums.length;
        return Math.max(
            nums[n-1]*nums[n-2]*nums[n-3],
            nums[0]*nums[1]*nums[n-1]
        );
    }
}