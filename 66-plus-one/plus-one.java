class Solution {
    public int[] plusOne(int[] digits) {
        
        //[1,2,3]
        //Ans. [1,2,4]

        //[1,9,9]
        // Ans. [2,0,0]
        int n=digits.length-1;
        for(int i=n;i>=0;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                return digits;
            }
            else{
                digits[i]=0;
            }
        }
        //[9,9]
        //Ans. [1,0,0]
        int newArray[]=new int[digits.length+1];
        newArray[0]=1;
        digits=newArray;
        return digits;
    }
}