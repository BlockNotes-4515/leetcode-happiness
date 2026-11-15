class Solution {
    public int numOfSubarrays(int[] arr) {

        /*
        int n=arr.length;
        int count=0;
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+arr[i];
        }

        //Calculating the Number of Sub-arrays with the odd sum
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                int length=(j-i+1);
                sum=prefix[j+1]-prefix[i];
                if(sum%2!=0){
                    count++;
                }
            }
        }
        return count;
        */
        //TLE due to O(N^N)=O(N^2);
        long even = 1;
        long odd = 0;
        long prefix = 0;
        long count = 0;

        int mod = 1000000007;

        for (int num : arr) {

            prefix += num;

            if (prefix % 2 == 0) {
                even++;
                count += odd;
            } else {
                odd++;
                count += even;
            }
            count %= mod;
        }
        return (int) count;
    }
}