class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        int max=0;
        for(int i=0;i<heights.length;i++){
            int minH=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minH=Math.min(minH,heights[j]);
                max=Math.max(max, (j-i+1)*minH);
            }
        }
        return max;
        */
        //Dynamic Approach by using the Stack DSA
        int[] nsei=new int[heights.length];
        int[] psei=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            nsei[i]=heights.length;
            psei[i]=-1;
        }

        //Implementing the Stack DSA
        Stack<Integer> stack=new Stack<>();

        //Imlementing the next smallest index values
        for(int i=0;i<heights.length;i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int indx=stack.peek();
                if(heights[i]<heights[indx]){
                    nsei[indx]=i;
                    stack.pop();
                }
                else{
                    stack.push(i);
                    break;
                }
            }
        }
        stack.clear();

         //Imlementing the previous smallest index values
        for(int i=heights.length-1;i>=0;i--){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int indx=stack.peek();
                if(heights[i]<heights[indx]){
                    psei[indx]=i;
                    stack.pop();
                }
                else{
                    stack.push(i);
                    break;
                }
            }
        }
        //calculating the maximum area of Rectangle
        int max=0;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,heights[i]*(nsei[i]-psei[i]-1));
        }
        return max;
    }
}