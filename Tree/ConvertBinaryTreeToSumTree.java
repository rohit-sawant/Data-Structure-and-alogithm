class Solution{
    int solve(Node root){
        
     if(root==null) return 0;
     int a = solve(root.left);
     int b = solve(root.right);
     int x = root.data;
     root.data = a+b;
     return a+b+x;
     
     
    }
    public void toSumTree(Node root){
         //add code here.
        
      solve(root);   
    }
}
