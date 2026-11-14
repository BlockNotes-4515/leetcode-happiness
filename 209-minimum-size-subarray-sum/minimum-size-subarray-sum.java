class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        //Concept of Sliding Window
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int sum=0;
        int left=0;

        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                min=Math.min(min,(right-left+1));
                sum-=nums[left];
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }
        

        /*Concept of Prefix Sum
        int n=nums.length;
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=prefix[j+1]-prefix[i];
                if(sum>=target){
                    int length=(j-i+1);
                    min=Math.min(min,length);
                }
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }*/

        //It's only solved by using sliding windiw O(n) unless in prefiSum shows Time Limit Exceeded with Time of O(n^n)=O(n^2)
    }
}