class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //Bruteforce Approach
        /*
        int n=temperatures.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    ans[i]=j-i;
                    break;
                }
            }
        }
        return ans;
        */
        int n=temperatures.length;
        int[] ans=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index=stack.pop();
                ans[index]=i-index;
            }
            stack.push(i);
        }
        return ans;
    }
}