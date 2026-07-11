class Solution {
    private static void bfs(int i ,boolean[]vis,List<List<Integer>> adj){
        int n = adj.size();
        vis[i] = true;
        Queue<Integer> q  = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int ele:adj.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n  = rooms.size();
        boolean [] vis = new boolean[n];
        vis[0] = true;
        bfs(0,vis,rooms);

      for (boolean ele : vis) {
    if (!ele) return false;
}

return true;
        
    }
}