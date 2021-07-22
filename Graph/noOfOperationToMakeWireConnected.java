//q link:https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/
class Solution {
    void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[src] = true;
        for(int i:adj.get(src)){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int m = connections.length;
        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
            
        
        if(m<n-1) return -1;
        for(int i=0;i<m;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean vis[] = new boolean[n];
        int c = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(i,adj,vis);
            }
        }
        return c-1;
    }
}
