class Solution {
    public int maxLength(int[] nums) {
        
       int n=nums.length;
       int ans=0;

       for(int low=0;low<n;low++){
        long product=1;
        long gcd=0;
        long lcm=1;

        for(int high=low;high<n;high++){
            product*=nums[high];
            gcd=findGcd(gcd,nums[high]);
            lcm=(lcm/findGcd(lcm,nums[high]))*nums[high];

            if(product==gcd*lcm){
                ans=Math.max(ans,high-low+1);
            }
        }
       }
       return ans;
    }
    private long findGcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}