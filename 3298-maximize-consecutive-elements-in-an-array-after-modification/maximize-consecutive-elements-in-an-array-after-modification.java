class Solution {
    public int maxSelectedElements(int[] nums) {
        
        Arrays.sort(nums);
        int n=nums.length;
        HashMap<Integer,Integer> dp=new HashMap<>();
        int ans=0;

        for(int num:nums){
            dp.put(num+2,
            Math.max(dp.getOrDefault(num+2,0),
            dp.getOrDefault(num+1,0)+1));

            dp.put(num+1,
            Math.max(dp.getOrDefault(num+1,0),
            dp.getOrDefault(num,0)+1));

            ans=Math.max(ans,dp.get(num+1));
            ans=Math.max(ans,dp.get(num+2));
        }
        return ans;
    }
}