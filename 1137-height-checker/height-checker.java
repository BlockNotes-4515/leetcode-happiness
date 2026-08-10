class Solution {
    public int heightChecker(int[] heights) {

        int n=heights.length;
        int[] expec=new int[n];
        expec=heights.clone();

        //Sorting the expected array
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(expec[j]>expec[j+1]){
                    int temp=expec[j];
                    expec[j]=expec[j+1];
                    expec[j+1]=temp;
                }
            }
        }
        //Count the heights which are not met with expected array
        int count=0;
        for(int i=0;i<n;i++){
            if(heights[i]!=expec[i]){
                count++;
            }
        }
        return count;
    }
}