class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] arr=new int[1001];
        for(int i=0;i<trips.length;i++){
            int start=trips[i][1];
            int end=trips[i][2];
            int value=trips[i][0];

            arr[start]+=value;
            arr[end]-=value;
            
        }
        int passenger=0;
        for(int i=0;i<1001;i++){
            passenger+=arr[i];
            if(passenger>capacity){
                return false;
            }
        }
        return true;
    }
}