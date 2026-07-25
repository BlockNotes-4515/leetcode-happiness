class Solution {
    public int maxProduct(int n) {
        
        int max1=0;
        int max2=0;
        while(n>0){
            int digits=n%10;
            if(digits>max1){
                max2=max1;
                max1=digits;
            }
            else  if(digits>max2){
                max2=digits;
            }
            n=n/10;
        }
        return max1*max2;
    }
}