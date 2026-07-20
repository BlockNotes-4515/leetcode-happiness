class Solution {
    public int removeDuplicates(int[] nums) {
       
       //1 2 2 3 4
       // 1 2 3 4 _
       //   j
       //  k
       int k=1;
       for(int j=1;j<nums.length;j++){
        if(nums[j]!=nums[j-1]){
            nums[k]=nums[j];
            k++;
        }
       }
       return k;
    }
}