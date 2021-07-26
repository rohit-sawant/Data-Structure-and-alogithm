// q link:https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
class Solution {
    // Function to return the diameter of a Binary Tree.
    static int max  = Integer.MIN_VALUE;
    int function(Node node){
        if(node==null){
            return 0;
        }
        int lh = function(node.left);
        int rh = function(node.right);
        max =  Math.max(max,lh+rh+1);
        return ((Math.max(lh,rh))+1);
    }
    int diameter(Node node) {
    //  int max = Integer.MIN_VALUE;
    int ans =  function(node);
    return ans+1;
        
    }
}
