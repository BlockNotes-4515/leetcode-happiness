class Solution {
    public int maxProduct(int[] nums) {

        /* Bruete force approach
        int n=nums.length;
        int left=0;
        int prod=1;
        int max=0, maxLen=0;

        for(int right=0;right<n;right++){

            prod*=nums[right];
            maxLen=Math.max(maxLen,prod);

            while(maxLen<max){
                prod/=nums[left];
                left++;
            }
            max=Math.max(max,maxLen);
        }
        return max;
        */

        //Optimized Approach using where we specially handle the negative values

        int n=nums.length;
        int left=0;
        int prod=nums[0];
        int minProd=nums[0];
        int max=nums[0], maxLen=0;

        for(int right=1;right<n;right++){

            if(nums[right]<0){
                int temp=prod;
                prod=minProd;
                minProd=temp;
            }
            prod=Math.max(nums[right],prod*nums[right]);
            minProd=Math.min(nums[right],minProd*nums[right]);

            max=Math.max(max,prod);
        }
        return max;
    }
}