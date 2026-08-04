class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int n=nums.length;

        //Sorting an array
        Arrays.sort(nums);
        
        //Traversing an arrayb list
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            int curr=nums[i];
            int prev=nums[i-1];
            while(curr-prev>1){
                prev++;
                ans.add(prev);
            }
        }
        return ans;
    }
}