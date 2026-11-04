class Solution {
    public int minMoves(int[] nums) {

        int max=nums[0];
        int moves=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            moves+=(max-nums[i]);
        }
        return moves;
    }
}