
class Solution {
    static final int MOD = 1_000_000_007;
    long[][] c = new long[1001][1001];

    public int numOfWays(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++)
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
        }

        List<Integer> a = new ArrayList<>();
        for (int x : nums) a.add(x);
        return (int) ((dfs(a) - 1 + MOD) % MOD);
    }

    long dfs(List<Integer> a) {
        int n = a.size();
        if (n<3) return 1;

        List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (a.get(i) < a.get(0)) l.add(a.get(i));
            else r.add(a.get(i));
        }

        return c[n-1][l.size()] *dfs(l) % MOD*dfs(r) % MOD;
    }
}
