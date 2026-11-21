
class Solution {
    int[] last = new int[26];
    List<Integer>[] tree;
    int[] newParent;
    public int[] findSubtreeSizes(int[] parent, String s) {
        
        int n = parent.length;
        tree = new ArrayList[n];
        newParent = parent.clone();
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        Arrays.fill(last, -1);
        // Find closest matching ancestors
        dfs1(0, s);
        // Rebuild modified tree
        for (int i = 0; i < n; i++) {
            tree[i].clear();
        }
        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }
        int[] ans = new int[n];
        // Calculate subtree sizes
        dfs2(0, ans);
        return ans;
    }
    void dfs1(int node, String s) {
        int c = s.charAt(node) - 'a';
        int previous = last[c];
        if (previous != -1) {
            newParent[node] = previous;
        }
        last[c] = node;
        for (int child : tree[node]) {
            dfs1(child, s);
        }
        // Backtrack
        last[c] = previous;
    }
    int dfs2(int node, int[] ans) {
        int size = 1;
        for (int child : tree[node]) {
            size += dfs2(child, ans);
        }
        ans[node] = size;
        return size;
    }
}
