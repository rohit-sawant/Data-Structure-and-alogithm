//q link: https://practice.geeksforgeeks.org/problems/topological-sort/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st = new Stack<Integer>();
        
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                Util(i,vis,adj,st);
            }
        }
        int topo[] = new int[V];
        int ind = 0;
        // System.out.print(st);
        while(!st.isEmpty()){
            // System.out.print(topo[i]+" ");
            topo[ind++]=st.pop();
            
        }
        return topo;
    }
    public static void Util(int i,boolean[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[i] = true;
        for(int neighbor:adj.get(i)){
            if(!vis[neighbor])
            {
                Util(neighbor,vis,adj,st);
            }
        }
        st.push(i);
    }
}
