class Solution {
    public boolean validMountainArray(int[] arr) {

       int n=arr.length;

       //1. Must have atleast 3 elements to form an mountain
       if(n<3){
        return false;
       }
       int i=0;

       //2. Uphill of the mountain
       while(i+1<n && arr[i]<arr[i+1]){
        i++;
       }

       //3. Peak cannot be the first or last element in an array
       if(i==0 || i==n-1){
        return false;
       }

       //4. Downhill of the mountin
       while(i+1<n && arr[i]>arr[i+1]){
        i++;
       }

       //5. Is we reach to the end of the mountain?
       return i==n-1;
    }
}