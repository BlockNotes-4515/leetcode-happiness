class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n=arr1.length;
        int m=arr2.length;
        int diff=0;
        int count=0;
        
        for(int i=0;i<n;i++){
            boolean valid=true;
            for(int j=0;j<m;j++){
                diff=Math.abs(arr1[i]-arr2[j]);
                if(diff<=d){
                    valid=false;
                    break;
                }
            }
            if(valid){
                count++;
            }
        }
        return count;
    }
}