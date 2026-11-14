class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        /* Bruete foce approach
        int n=nums.size();
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums.get(j);
                int length=(j-i+1);
                if(length>=l && length<=r && sum>0){
                    min=Math.min(min,sum);
                }
                if(length>r){
                    break;
                }
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }
        */

        //Calculating by using the concept of prefixSum
        int n=nums.size();
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums.get(i);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                int length=(j-i+1);
                if(length>=l && length<=r){
                    sum=prefix[j+1]-prefix[i];
                }
                if(sum>0){
                    min=Math.min(min,sum);
                }
                /*
                if(sum>r){
                    break;
                }*/
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }
    }
}