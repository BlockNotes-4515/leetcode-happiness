class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:invocations){
            graph.get(e[0]).add(e[1]);
        }
        boolean[] vis=new boolean[n];
        dfs(k,graph,vis);
        for(int[] e:invocations){
            if(!vis[e[0]]&& vis[e[1]]){
                List<Integer> ans=new ArrayList<>();
                for(int i=0;i<n;i++) ans.add(i);
                return ans;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]) ans.add(i);
        }
        return ans;
    }
    private void dfs(int node,List<List<Integer>> graph, boolean[] vis){
        vis[node]=true;
        for(int next:graph.get(node)){
            if(!vis[next]){
                dfs(next,graph,vis);
            }
        }
    }
}