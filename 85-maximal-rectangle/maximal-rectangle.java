class Solution {
    public int largestRectangleArea(int[] heights) {
        //Dynamic Approach by using the Stack DSA    T: O(n) || S: O(n);
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
    public int maximalRectangle(char[][] matrix) {
        
        int[][] mat=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int col=0;col<matrix[0].length;col++){
            mat[0][col]=matrix[0][col]=='1'?1 : 0;
        }
        max=Math.max(max,largestRectangleArea(mat[0]));

        for(int row=1;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                mat[row][col]=matrix[row][col]=='1'?mat[row-1][col]+1 : 0;
            }
            max=Math.max(max,largestRectangleArea(mat[row]));
        }
        return max;
    }
}