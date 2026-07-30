class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //left->right gives (Top Column)
        //top->bottom gives (right column)
        //right->left gives (bottom row)
        //bottom->top gives (left column)
        List<Integer> ans=new ArrayList<>();
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;

        while(top<=bottom && left<=right){

            //when we move from left->right gives us top row
            for(int j=left;j<=right;j++){
                ans.add(matrix[top][j]);
            }
            top++;

            //Whwn we move from top->bottom gives right column
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;

            //When we move from right->left give bottom row here
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            //when we move from bottom->top it gives us left column
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
