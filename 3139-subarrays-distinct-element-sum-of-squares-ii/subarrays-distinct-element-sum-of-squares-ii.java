/*
class Solution {
    public int sumCounts(int[] nums) {

        int n=nums.length;
        int sum=0;
        
        //Calculating and getting the elements from an array
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums[j]);
                int count=set.size();
                sum+=(count*count);
            }
        }
        return sum;
    }
}
*/


class Solution {
    static final long MOD = 1_000_000_007L;
    long[] s, sq, lazy;
    int n;

    void apply(int p, int l, int r, long v) {
        long len = r - l + 1L;
        sq[p] = (sq[p] + 2 * v * s[p] + v * v % MOD * len) % MOD;
        s[p] = (s[p] + v * len) % MOD;
        lazy[p] = (lazy[p] + v) % MOD;
    }

    void push(int p, int l, int r) {
        if (lazy[p] == 0 || l == r) return;
        int m = (l + r) / 2;
        apply(p * 2, l, m, lazy[p]);
        apply(p * 2 + 1, m + 1, r, lazy[p]);
        lazy[p] = 0;
    }

    void update(int p, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(p, l, r, 1);
            return;
        }
        push(p, l, r);
        int m = (l + r) / 2;
        update(p * 2, l, m, ql, qr);
        update(p * 2 + 1, m + 1, r, ql, qr);
        s[p] = (s[p * 2] + s[p * 2 + 1]) % MOD;
        sq[p] = (sq[p * 2] + sq[p * 2 + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        n = nums.length;
        s = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans=0;
        for (int i=0; i<n; i++) {
            update(1, 0, n - 1, last[nums[i]] + 1, i);
            last[nums[i]] = i;
            ans=(ans + sq[1]) % MOD;
        }
        return (int) ans;
    }
}
