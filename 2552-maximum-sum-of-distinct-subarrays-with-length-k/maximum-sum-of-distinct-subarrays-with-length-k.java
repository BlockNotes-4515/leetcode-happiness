class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        long sum=0;
        long max=0;
        int i=0;
        for(int j=0;j<n;j++){
            sum=sum+nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            //Checking the window slide
            if(j-i+1==k){
                if(map.size()==k){
                    max=Math.max(max,sum);
                }
                sum=sum-nums[i];
                map.put(nums[i],map.get(nums[i])-1);

                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return max;
    }
}