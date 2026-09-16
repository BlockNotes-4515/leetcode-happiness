class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //First we need to sort an array
        //First Approach Brute Force Approach
        /*
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
        */
        HashSet<Integer> set=new HashSet<>();

        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}