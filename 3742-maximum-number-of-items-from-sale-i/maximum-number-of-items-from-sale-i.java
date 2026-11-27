class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Calculate reward for each item type
        int[] reward = new int[n];

        for (int i = 0; i < n; i++) {
            reward[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    reward[i]++;
                }
            }
        }

        // Step 2: Sort items by price in descending order
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) ->
            Integer.compare(items[b][1], items[a][1])
        );

        int INF = -1000000000;

        // dp[b] = maximum reward using exact cost b
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        int ans = 0;
        int idx = 0;

        // Step 3: Process items grouped by price
        while (idx < n) {

            int price = items[order[idx]][1];

            // At least one item of current price must be selected
            int[] take = new int[budget + 1];
            Arrays.fill(take, INF);

            int end = idx;

            while (end < n && items[order[end]][1] == price) {

                int id = order[end];
                int cost = items[id][1];
                int value = reward[id];

                for (int b = budget; b >= cost; b--) {

                    if (dp[b - cost] != INF) {
                        take[b] = Math.max(
                            take[b],
                            dp[b - cost] + value
                        );
                    }

                    if (take[b - cost] != INF) {
                        take[b] = Math.max(
                            take[b],
                            take[b - cost] + value
                        );
                    }
                }

                end++;
            }

            // Step 4: Calculate answer
            for (int b = 0; b <= budget; b++) {

                if (take[b] != INF) {

                    int extra = (budget - b) / price;

                    ans = Math.max(ans, take[b] + extra);
                }
            }

            // Step 5: Add current price group to normal DP
            for (int k = idx; k < end; k++) {

                int id = order[k];
                int cost = items[id][1];
                int value = reward[id];

                for (int b = budget; b >= cost; b--) {

                    if (dp[b - cost] != INF) {
                        dp[b] = Math.max(
                            dp[b],
                            dp[b - cost] + value
                        );
                    }
                }
            }
            idx = end;
        }
        return ans;
    }
}
