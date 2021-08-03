/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max(TreeNode root){
        if(root.right==null){
            return root.val;
        }
        return max(root.right);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root ==null){
            return null;
        }
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else
        {
            if(root.right!=null && root.left!=null){
                int lmax = max(root.left);
                root.val =  lmax;
                root.left = deleteNode(root.left,lmax);
                return root;
            }
            else if(root.right!=null)
            {
                return root.right;
            }
            else if(root.left!=null){
                return root.left;
            }
            else
            {
                return null;
            }
        }
        return root;
            
        
    }
}
