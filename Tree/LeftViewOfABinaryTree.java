// q link:https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
class Tree
{
     static ArrayList<Integer> al;
     static int maxlevel;
    void Util(Node root,int level){
        if(root==null){
            return ;
            
        }
        if(maxlevel<level){
            al.add(root.data);
            maxlevel = level;
        }
        Util(root.left,level+1);
        Util(root.right,level+1);
        
        
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {   
        al = new ArrayList<Integer>();
        maxlevel = Integer.MIN_VALUE;
       Util(root,0);
        return al;
      
     
    }
}
