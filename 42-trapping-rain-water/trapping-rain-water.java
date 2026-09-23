class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] Pmax=PrefixMax(height);
        int[] Smax=SuffixMax(height);
        int ans=0;

        for(int i=1;i<n-1;i++){
            int lb=Pmax[i-1];
            int rb=Smax[i+1];
            int yb=Math.min(lb,rb);
            int amt=yb-height[i];
            if(amt>0){
                ans=ans+amt;
            }
        }
        return ans;
    }


        static int[] PrefixMax(int[] arr){
                int n=arr.length;
                int[] Pmax=new int[n];
                Pmax[0]=arr[0];
                for(int i=1;i<n;i++){
                    Pmax[i]=arr[i]>Pmax[i-1]
                    ?arr[i]
                    :Pmax[i-1];
                }
                return Pmax;
        }
        static int[] SuffixMax(int[] arr){
                int n=arr.length;
                int[] Smax=new int[n];
                Smax[n-1]=arr[n-1];
                for(int i=n-2;i>=0;i--){
                    Smax[i]=arr[i]>Smax[i+1]
                    ?arr[i]
                    :Smax[i+1];
                }
                return Smax;
        }
}