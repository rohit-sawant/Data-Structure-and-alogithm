//q link:https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
         ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        if(node==null){
            return list;
        }
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            list.add(n.data);
             if(n.right!=null){
                q.add(n.right);
            }
            if(n.left!=null){
                q.add(n.left);
            }
           
            
        }
        Collections.reverse(list);
        return list;
    }
}      
