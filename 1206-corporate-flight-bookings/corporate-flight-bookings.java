class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] diff=new int[n];

        for(int i=0;i<bookings.length;i++){
            int start=bookings[i][0]-1;
            int end=bookings[i][1]-1;
            int value=bookings[i][2];

            diff[start]+=value;
            if(end+1<n){
                diff[end+1]-=value;
            } 
        }
        int[] prefix=new int[n];
        prefix[0]=diff[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+diff[i];
        }
        return prefix;
    }
}