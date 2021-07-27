class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first =first;
        this.second = second;
    }
}
class Solution
{
    static TreeMap<Integer,Pair> map ;
   
    //Function to return a list containing the bottom view of the given tree.
     void Util(Node root,int dist,int level){
       if(root==null){
           return;
       }
       if((!map.containsKey(dist))||(map.get(dist).second<level)){
           map.put(dist,new Pair(root.data,level));
       }
       Util(root.right,dist+1,level+1);
       Util(root.left,dist-1,level+1);
       
       
    }
    public ArrayList <Integer> bottomView(Node root)
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
