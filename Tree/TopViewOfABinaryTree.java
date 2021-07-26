// question link: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.

    static TreeMap<Integer,Pair> map;
    void Util(Node root,int dist,int level){
       if(root==null){
           return;
       }
       if((!map.containsKey(dist))||(map.get(dist).second>level)){
           map.put(dist,new Pair(root.data,level));
       }
       Util(root.left,dist-1,level+1);
       Util(root.right,dist+1,level+1);
    }
    
     ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        map = new TreeMap<>();
        
        if(root==null){
            return al;
        }
        Util(root,0,0);
        // System.out.print(map);
        for(Pair ans: map.values()){
            al.add(ans.first);
        }
        return al;
        // add your code
        
    }
}
