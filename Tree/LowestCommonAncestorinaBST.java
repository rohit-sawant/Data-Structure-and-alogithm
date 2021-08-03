class BST
{   
    Node Util(Node root,int max,int min){
        if(root.data>min && root.data>max){
            return Util(root.left,min,max);
        }
        if(root.data<min && root.data<max){
            return Util(root.right,min,max);
        }
        return root;
    }
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
       int max =  Math.max(n1,n2);
       int min = Math.min(n1,n2);
       Node ans = Util(root,n1,n2);
       return ans;
    }
    
}
