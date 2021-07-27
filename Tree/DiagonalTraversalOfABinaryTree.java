class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Tree
{
     static TreeMap<Integer,ArrayList<Integer>> map;
     void Util(Node root,int dist,int level){
        if(root==null){
            return;
        }
        int index = ((Math.abs(dist-level))/2);
        map.putIfAbsent(index, new ArrayList<Integer>());
        map.get(index).add(root.data);
        Util(root.left,dist-1,level+1);
        Util(root.right,dist+1,level+1);
        
    }
   
      ArrayList<Integer> diagonal(Node root)
      {
          ArrayList<Integer> ans = new ArrayList<>();
          map = new TreeMap<Integer,ArrayList<Integer>>();
          Util(root,0,0);
          for(ArrayList<Integer> val:map.values()){
              ans.addAll(val);
          }
        return ans;
      }
}
