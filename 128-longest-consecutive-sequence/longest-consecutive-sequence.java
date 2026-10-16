class Solution {
    public int longestConsecutive(int[] nums) {
        
        //Applying the bruete force approach
        int n=nums.length;
        if(n==0){
            return 0;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int longest=1;
        for(int num:set){
            if(set.contains(num-1)){
                continue;
            }
                int curr=num;
                int count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest=Math.max(longest,count);
        }
        return longest;
    }
}