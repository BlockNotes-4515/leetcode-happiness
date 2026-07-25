class Solution {
    public int heightChecker(int[] heights) {
        
        int n=heights.length;
        int expec[]=new int[n];
        expec=heights.clone();

        //Bubble sort an expected array
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(expec[j]>expec[j+1])
                {
                    int temp=expec[j];
                    expec[j]=expec[j+1];
                    expec[j+1]=temp;
                }
            }
        }
        //Comparing the height original and expected array result
        int count=0;
        for(int i=0;i<n;i++){
            if(heights[i]!=expec[i]){
                count++;
            }
        }
        return count;
    }
}