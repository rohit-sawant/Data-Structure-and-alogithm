class Solution
{
    static int i=0;

    static void Inorder(Node root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        Inorder(root.left,al);
        al.add(root.data);
        Inorder(root.right,al);
    }
     static void create_BST(Node root,int[] pt,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        create_BST(root.left,pt,al);
        root.data = al.get(i);
        i++;
        create_BST(root.right,pt,al);
        
    }
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root) 
    {
       // Your code here
        ArrayList<Integer> al=new ArrayList<Integer>();
       Inorder(root,al);
       int[] arr=new int[1];
       Collections.sort(al);
    //   System.out.println(sortedarr);
       create_BST(root,arr,al);
       return root;
       
    }
}
 
