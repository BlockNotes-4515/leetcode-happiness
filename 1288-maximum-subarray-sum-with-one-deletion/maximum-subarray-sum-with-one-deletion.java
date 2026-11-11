class Solution {
    public int maximumSum(int[] arr) {
        
        int n=arr.length;
        int noDelete=arr[0];
        int oneDelete=0;
        int ans=arr[0];

        for(int i=1;i<n;i++){

            //No delete value calculations
            int prev=noDelete;
            noDelete=Math.max(noDelete+arr[i],arr[i]);

            //Calculating the oneDelete values
            oneDelete=Math.max(prev,oneDelete+arr[i]);

            //Calculating the main_result set
            ans=Math.max(ans,Math.max(noDelete,oneDelete));
        }
        return ans;
    }
}