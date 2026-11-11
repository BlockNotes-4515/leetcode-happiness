class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        long ans=0;

        long costSep=(long) cost1*need1 + (long) cost2*need2;

        int common=Math.min(need1,need2);

        long costMixed=(long) common*costBoth+(long)(need1-common)*cost1+
        (long)(need2-common)*cost2;

        long costOnlyBoth=(long) Math.max(need1,need2)*costBoth;
        ans=Math.min(costSep,Math.min(costMixed,costOnlyBoth));

        return ans;
    }
}