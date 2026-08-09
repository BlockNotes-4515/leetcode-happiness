class Solution {
    public boolean isPerfectSquare(long num) {
        
        long left=1;
        Long right=num;
        while(left<=right){
            long mid=left+(right-left)/2;
            long result=mid*mid;

            if(result==num){
                return true;
            }
            else if(result<num){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}