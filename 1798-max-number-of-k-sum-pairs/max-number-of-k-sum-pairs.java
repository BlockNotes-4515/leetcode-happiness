class Solution {
    public int maxOperations(int[] nums, int k) {
       
       Arrays.sort(nums);
       int count=0;
       int left=0;
       int right=nums.length-1;
       
       while(left<right){
        int sum=nums[left]+nums[right];

        if(sum==k){
            count++;
            left++;
            right--;
        }
        else if(sum<k){
            left++;
        }
        else{
            right--;
        }
       }
       return count;
    }
}

//By Implementing the Brute Force Approach
 /*
        int n=nums.length; //k
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==k){
                    count++;
                    j++;
                }
            }
        }
        return count;
        */