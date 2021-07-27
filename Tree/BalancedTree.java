class Tree
{
    static int f;
    int height(Node node){
        if(node==null) return 0;
        int rh = height(node.right);
        int lh = height(node.left);
        
        if(Math.abs(lh-rh)>1){
            // System.out.println(lh+"\n"+rh);
            // System.out.println(node.data);
            f=1;
            return -1;
        }
        return (Math.max(lh,rh)+1);
    }
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        f=0;
	    if(root==null) return true;
	    int ans = height(root);
	  
	   if(f==0) return true;
	    return false;
    }
}

