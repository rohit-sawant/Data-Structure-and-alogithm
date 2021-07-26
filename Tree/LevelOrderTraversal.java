class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        if(node==null){
            return list;
        }
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            list.add(n.data);
            if(n.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
            
        }
        return list;
        
    }
}
