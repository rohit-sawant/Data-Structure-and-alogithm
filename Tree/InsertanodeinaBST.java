class Solution
{
    //Function to insert a node in a BST.
   
    Node insert(Node root,int key){
        if(root==null){
            root = new Node(key);
            return root;
        }
        if(root.data>key)
        {
            root.left = insert(root.left,key);
        }
        else if(root.data<key){
            root.right = insert(root.right,key);
        }
        return root;
    }
}
