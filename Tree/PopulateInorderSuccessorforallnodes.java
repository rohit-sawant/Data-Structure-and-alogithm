class Solution{
     static Node prev = null;
    void Util(Node root){
        if(root==null){
            return;
        }
        Util(root.left);
        if(prev!=null){
            prev.next = root;
            // System.out.print(prev.next.data);
            
        }
        prev = root;
        Util(root.right);
    }
    public void populateNext(Node root){
        //code here
        
        Util(root);
        
    }
}
