class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Count frequency of each factor
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 2: Count possible free items for each factor
        int[] count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                count[i] += freq[j];
            }
            count[i]--;
        }

        // Step 3: Find minimum price
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 4: Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long remaining = budget;
        long bonus = 0;

        // Step 5: Greedily buy bonus-generating copies
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // No benefit if price >= 2 * minimum price
            if (2L * minPrice <= price) {
                break;
            }

            long canBuy = remaining / price;

            long take = Math.min((long) count[factor], canBuy);

            bonus += take;
            remaining -= take * price;
        }
        // Step 6: Buy additional cheapest items
        long ans = 2 * bonus + remaining / minPrice;

        return (int) ans;
    }
}
