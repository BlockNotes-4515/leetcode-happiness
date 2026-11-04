
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            if (map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val) - 1);
            }
        }

        void add(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                addMap(left, val);
                leftSize++;
                leftSum += val;
            } else {
                addMap(right, val);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        void remove(int val) {

            if (left.containsKey(val)) {
                removeMap(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                removeMap(right, val);
                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        void balance() {

            while (leftSize > rightSize + 1) {
                int val = left.lastKey();

                removeMap(left, val);
                leftSize--;
                leftSum -= val;

                addMap(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {
                int val = right.firstKey();

                removeMap(right, val);
                rightSize--;
                rightSum -= val;

                addMap(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {

            int median = left.lastKey();

            return (long) median * leftSize - leftSum
                 + rightSum - (long) median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        MedianWindow window = new MedianWindow();
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {

            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                dp[j][i] = dp[j][i - 1];

                if (i >= x && dp[j - 1][i - x] != INF) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }
        return dp[k][n];
    }
}
