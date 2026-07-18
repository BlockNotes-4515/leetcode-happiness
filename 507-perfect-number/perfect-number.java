class Solution {
    public boolean checkPerfectNumber(int num) {
        
        int n=num;
        if(n<=0)
        return false;

        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        return sum==n;
    }
}