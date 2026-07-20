class Solution {
    public int maxProfit(int[] prices) {

        //Taking the maxProfit as initial.
        int maxProfit=0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;  
    }
}