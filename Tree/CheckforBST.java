public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    
    // static int min = Integer.MIN_VALUE;
    // static int max = Integer.MAX_VALUE;
    boolean Util(Node root,int min,int max){
         if(root==null){
            return true;
        }
        return (root.data>min && root.data<max && Util(root.left,min,root.data) && Util(root.right,root.data,max));
        // code here.
    }
    boolean isBST(Node root)
    {
       return Util(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
}
