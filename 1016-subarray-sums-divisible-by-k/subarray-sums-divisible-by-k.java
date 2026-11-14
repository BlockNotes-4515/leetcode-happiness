class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        /* Prefix Sum Approach but TLE O(n^n)=O(n^2)

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
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;
        */
         int n = nums.length;

        int[] freq = new int[k];

        // Initially, remainder 0 occurs once
        freq[0] = 1;

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Calculate prefix sum
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            // Count previous prefix sums with same remainder
            count += freq[rem];
            freq[rem]++;
        }
        return count;
    }
}