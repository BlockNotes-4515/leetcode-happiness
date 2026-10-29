import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] in = new int[n], out = new int[n], dep = new int[n];
        int[][] up = new int[17][n];
        int[] timer = {0};
        dfs(0, 0, g, in, out, dep, up, timer);

        BIT bit = new BIT(n + 1);
        char[] a = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int m = 1 << (a[i] - 'a');
            bit.update(in[i], m);
            bit.update(out[i] + 1, m);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");
            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                char c = p[2].charAt(0);
                if (a[u] != c) {
                    int m = (1 << (a[u] - 'a')) ^ (1 << (c - 'a'));
                    bit.update(in[u], m);
                    bit.update(out[u] + 1, m);
                    a[u] = c;
                }
            } else {
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v, dep, up);
                int m = bit.query(in[u]) ^ bit.query(in[v])
                      ^ (1 << (a[l] - 'a'));
                ans.add((m & (m - 1)) == 0);
            }
        }
        return ans;
    }

    void dfs(int u, int p, List<Integer>[] g, int[] in, int[] out,
             int[] dep, int[][] up, int[] timer) {
        in[u] = timer[0]++;
        up[0][u] = p;

        for (int j = 1; j < 17; j++)
            up[j][u] = up[j - 1][up[j - 1][u]];

        for (int v : g[u]) {
            if (v == p) continue;
            dep[v] = dep[u] + 1;
            dfs(v, u, g, in, out, dep, up, timer);
        }
        out[u] = timer[0] - 1;
    }

    int lca(int u, int v, int[] dep, int[][] up) {
        if (dep[u] < dep[v]) {
            int t = u; u = v; v = t;
        }
        int d = dep[u] - dep[v];

        for (int j = 0; j < 17; j++)
            if ((d & (1 << j)) != 0) u = up[j][u];

        if (u == v) return u;

        for (int j = 16; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }
        return up[0][u];
    }

    class BIT {
        int[] t;
        BIT(int n) { t = new int[n + 1]; }

        void update(int i, int x) {
            for (i++; i < t.length; i += i & -i) t[i] ^= x;
        }

        int query(int i) {
            int x = 0;
            for (i++;i>0;i-=i&-i)x^=t[i];
            return x;
        }
    }
}