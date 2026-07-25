class Solution {
    static boolean ans;
    public void dfs(int i, List<List<Integer>> adj,boolean[]vis,boolean[] path){
        vis[i] = true;
        path[i] = true;
        for(int ele:adj.get(i)){
            if(path[ele]==true){
                ans = false; // false means  there is a cycle
                return;
            }
            if(vis[ele]==false) dfs(ele,adj,vis,path);
        }
        path[i] = false;

    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true; // true means no cycle
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =1; i<=n; i++) adj.add(new ArrayList<>());
        for(int i =0; i<pre.length; i++){
            int a = pre[i][0] , b = pre[i][1]; // b->a edge
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i =0; i<n; i++){
            if(vis[i]==false) dfs(i,adj,vis,path);
        }
        return ans;
       
    }
}

