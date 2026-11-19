class Solution {
    public int minimizeSum(int[] nums) {

        Arrays.sort(nums);
        int n=nums.length;

        //Putting the main actual logics here
        int a=nums[n-3]-nums[0];
        int b=nums[n-2]-nums[1];
        int c=nums[n-1]-nums[2];

        int min=Integer.MAX_VALUE;
        min=Math.min(a,Math.min(b,c));

        return min;
    }
}