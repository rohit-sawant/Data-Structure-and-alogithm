// question link:https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
class Solution{
    //Function to return list containing elements of right view of binary tree.
    static int maxlevel;
    static ArrayList<Integer> al;
    void Util(Node root,int level){
        if(root==null){
            return;
        }
        if(maxlevel<level){
            al.add(root.data);
            maxlevel = level;
        }
        Util(root.right,level+1);
        Util(root.left,level+1);
    }
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        al = new ArrayList<>();
        maxlevel = Integer.MIN_VALUE;
        Util(node,0);
        return al;
    }
}

