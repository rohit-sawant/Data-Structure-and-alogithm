class Tree
{
    //Function to find the minimum element in the given BST.
    int minValue(Node node)
    {
        if(node.left==null){
            return node.data;
        }
        return minValue(node.left);
    }
}
