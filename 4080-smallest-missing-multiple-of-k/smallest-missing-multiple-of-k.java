class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        int n=nums.length;
        int count=0;

        //Sorting an array here
        Arrays.sort(nums);

        int multiple=k;

        for(int i=0;i<n;i++){
            if(nums[i]==multiple){
                multiple+=k;
            }
        }
        return multiple;
    }
}