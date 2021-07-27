class Solution
{
    static ArrayList<Integer> ans;
    void leftBoundary(Node node){
        if(node==null){
            return ;
        }
        if(node.left!=null){
            ans.add(node.data);
            leftBoundary(node.left);
        }
        else if(node.right!=null){
            ans.add(node.data);
            leftBoundary(node.right);
        }
    }
    void rightBoundary(Node node){
         if(node==null){
            return ;
        }
        if(node.right!=null){
            rightBoundary(node.right);
            ans.add(node.data);
        }
        else if(node.left!=null){
            rightBoundary(node.left);
            ans.add(node.data);
        }
    }
    void leafNode(Node node){
        if(node==null){
            return;
        }
        leafNode(node.left);
        if(node.left==null && node.right==null){
            ans.add(node.data);
           
        }
        // if(node.left!=null)
        // if(node.right!=null)
        leafNode(node.right); 
    }
	ArrayList <Integer> printBoundary(Node node)
	{
	    
	    ans = new ArrayList<Integer>();
	    if(node==null){
	        return ans;
	    }
	    ans.add(node.data);
	    leftBoundary(node.left);
	    leafNode(node.left);
	    leafNode(node.right);
	    rightBoundary(node.right);
	    return ans;
	}
}
