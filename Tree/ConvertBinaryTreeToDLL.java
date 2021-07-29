class Solution
{
    static Node head;
    static Node prev;
    void convert(Node root){
        if(root==null) return;
        convert(root.left);
        if(prev==null){
            head = root;
            prev = root;
        }
        else
        {
            root.left = prev;
            prev.right = root;
            prev = root;
        }
        convert(root.right);
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here
	head =null;
	prev =null;
	convert(root);
	return head;
    }
}
