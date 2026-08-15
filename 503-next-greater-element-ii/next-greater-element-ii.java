class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        //We use with stack approach  with twice because it's a circular array
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            res[i]=-1;
        }
        for(int i=0;i<n;i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int indx=stack.peek();
                if(nums[i]>nums[indx]){
                    res[indx]=nums[i];
                    stack.pop();
                }
                else{
                    stack.push(i);
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int indx=stack.peek();
                if(nums[i]>nums[indx]){
                    res[indx]=nums[i];
                    stack.pop();
                }
                else{
                    stack.push(i);
                    break;
                }
            }
        }
        return res;
    }
}