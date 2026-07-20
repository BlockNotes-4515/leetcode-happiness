class Solution {
    public int maxProfit(int[] prices) {

        //Taking the value of 'maxProfit' as it's initial value.

        int maxProfit=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                maxProfit=maxProfit+prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}