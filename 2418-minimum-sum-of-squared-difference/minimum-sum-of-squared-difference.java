class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

//Brute force approach
/*
        int n=nums1.length;
        int k=k1+k2;
        int diff[]=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
        } 
        while(k>0){
            int maxIndex=0;
            for(int i=1;i<n;i++){
                if(diff[i]>diff[maxIndex]){
                    maxIndex=i;
                }
            }
            if(diff[maxIndex]==0){
                break;
            }
            diff[maxIndex]--;
            k--;
        }
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=(long)(diff[i]*diff[i]);
        }
        return sum;
        */
        //Best Optimised approach
        long k=(long)k1+k2;
        int freq[]=new int[100001];
        int max=0;

        for(int i=0;i<nums1.length;i++){
            int d=Math.abs(nums1[i]-nums2[i]);
            freq[d]++;
            max=Math.max(max,d);
        }
        for(int d=max;d>0 && k>0;d--){
            int take=(int)Math.min(k,freq[d]);
            freq[d]-=take;
            freq[d-1]+=take;
            k-=take;
        }
        long sum=0;
        for(int d=1;d<=max;d++){
            sum+=(long)d*d*freq[d];
        }
        return sum;
    }
}