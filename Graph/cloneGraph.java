//q link:https://leetcode.com/problems/clone-graph/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> queue =new ArrayDeque<>();
        queue.add(node);
        map.put(node,new Node(node.val));
        while(!queue.isEmpty()){
            Node h = queue.poll();
            for(Node n: h.neighbors){
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val));
                    queue.add(n);
                }
                map.get(h).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}
