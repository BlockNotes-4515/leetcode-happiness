class Solution {
    public int[][] generateMatrix(int n) {
        
        int matrix[][]=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int num=1;
        while(top<=bottom && left<=right){

            //Moving from the left->right gets the top most value row (top row)
            for(int j=left;j<=right;j++){
                matrix[top][j]=num++;
            }
            top++;

            //Moving from top->bottom then we will get right column
            for(int i=top;i<=bottom;i++){
                matrix[i][right]=num++;
            }
            right--;

            //Moving from right->left as we get the bottom most row (bottom row)
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    matrix[bottom][j]=num++;
                }
                bottom--;
            }

            //As we have to go from bottom->top we get the value right column
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left]=num++;
                }
                left++;
            }
        }
        return matrix;
    }
}