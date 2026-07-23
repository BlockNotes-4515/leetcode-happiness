class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n=nums.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){

            //Squaring of all items in an array.
            result[i]=nums[i]*nums[i];
        }
        //Sort the array simply.
        Arrays.sort(result);
        return result;
    }
}