class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Using the HashMap data structures
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int previousIndx=map.get(nums[i]);

                if(i-previousIndx<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}