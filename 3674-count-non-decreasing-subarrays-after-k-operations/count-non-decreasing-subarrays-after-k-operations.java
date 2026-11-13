
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<long[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            long x = nums[left];
            long count = 1;
            long sum = x;

            // Merge smaller prefix maximum groups
            while (!dq.isEmpty() && dq.peekFirst()[0] <= x) {

                long[] cur = dq.pollFirst();

                cost += x * cur[1] - cur[2];

                count += cur[1];
                sum += x * cur[1];
            }
            dq.addFirst(new long[]{x, count, sum});

            // Shrink window if operations exceed k
            while (cost > k) {

                long[] last = dq.peekLast();

                cost -= last[0] - nums[right];

                last[1]--;
                last[2] -= last[0];

                if (last[1] == 0) {
                    dq.pollLast();
                }
                right--;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
