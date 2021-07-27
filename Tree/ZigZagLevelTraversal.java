class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    Queue<Node> q = new LinkedList<Node>();
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(root==null){
	        return ans;
	    }
	   
	    boolean toggle = true;
	    q.add(root);
	   // System.out.print(q);
	    while(!q.isEmpty()){
	        int size = q.size();
	        ArrayList<Integer> al = new ArrayList<>();
	        while(size!=0){
	            Node n = q.poll();
	            
	           
	                al.add(n.data);
	                 if(n.left!=null)
	                 {
	                     q.add(n.left);
	                 }
	                if(n.right!=null){
	                    q.add(n.right);
	                } 
	            
	           // al.add(n.data);
	           size--;
	        }
	        if(toggle){
	            ans.addAll(new ArrayList<>(al));
	        }
	        else
	        {
	            Collections.reverse(al);
	            
	            ans.addAll(new ArrayList<>(al));
	            
	        }
	       // System.out.println(toggle+","+al);
	        toggle = !toggle;
	        
	        
	    }
	    return ans;
	}
}
