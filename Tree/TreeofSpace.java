// question link :https://leetcode.com/discuss/interview-question/1279262/Juspay-Tree-of-Space-Locking-and-Unlocking-N-Ary-Tree
package Learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map;


class Node{
    boolean isLocked;
    int lockedby;
    int parent;
    Map<Integer, Set<Integer>> lockedChildren = new HashMap<Integer, Set<Integer>>();
    public Node(int value,int noofchildren){
        isLocked = false;
        lockedby = -1;
        parent = (value==0)?-1:((value-1)/noofchildren);

    }

    @Override
    public String toString() {
        return "Node{" +
                "isLocked=" + isLocked +
                ", lockedby=" + lockedby +
                ", parent=" + parent +
                ", lockedChildren=" + lockedChildren +
                '}';
    }
}
public class TreeofSpace {
    static String perform(int operation,Node n,int userid){

        if(operation==LOCK){
            System.out.println("Entering  lock operation");
            System.out.println(n.toString());
            if(n.isLocked){
                return "the node itself is locked";
            }
            if(n.lockedChildren.size()!=0){
                return "child locked";
            }
            int t = n.parent;
            while(t!=-1){
                Node x = tree_arr.get(t);
                if(x.isLocked){
                    return "parent is locked";
                }
                t = x.parent;
            }
//            System.out.println("node got locked");
            n.isLocked = true;
            n.lockedby = userid;
            t = n.parent;
            while(t!=-1){
                Node x = tree_arr.get(t);
                Set<Integer> lockedtreeinteger;
                if(x.lockedChildren.containsKey(userid)){
                    lockedtreeinteger = x.lockedChildren.get(userid);

                }
                else
                {
                    lockedtreeinteger = new HashSet<>();
                }
                lockedtreeinteger.add(tree_arr.indexOf(n));
                x.lockedChildren.put(userid,lockedtreeinteger);
                t = x.parent;

            }
            System.out.println(n.toString());
            System.out.println("Exitin succesfully");
            return "true";

        }
        if(operation==UNLOCK){
            System.out.println("Enter unlock");
            System.out.println(n.toString());
            if(!n.isLocked){
                return "child locked";
            }
            if(n.lockedby!=userid){
                return "locked by differnt user id";
            }
            n.isLocked= false;
            n.lockedby = -1;
            int val = tree_arr.indexOf(n);
            int t = n.parent;
            while(t!=-1){
                Node x = tree_arr.get(t);
                Set<Integer> lockedtreeinteger = x.lockedChildren.get(userid);
                lockedtreeinteger.remove(val);
                if(lockedtreeinteger.isEmpty()){
                    x.lockedChildren.remove(userid);
                }
                t = x.parent;
            }
            System.out.println(n.toString());
            System.out.println("Exiting successfully");
            return "true";
        }
        if(operation==UPGRADE){
            System.out.println("Entering upgrade");
            System.out.println(n.toString());
            if(n.isLocked){
                return "already locked";
            }
            if(n.lockedChildren.size()!=1){
                return "locked by some other child in descendant";
            }
            if(!n.lockedChildren.containsKey(userid)){
                return "does not contain user id";
            }
            Set<Integer> lockedtreeinteger = n.lockedChildren.get(userid);
            Integer[] array = lockedtreeinteger.toArray(new Integer[lockedtreeinteger.size()]);
            for(int i:array){
                perform(UNLOCK,tree_arr.get(i),userid);
            }

            perform(LOCK,n,userid);
            System.out.println("Exiting succesfully");
            return "true";
        }
        return "false";
    }
    public static int LOCK  =1;
    public static int UNLOCK   =2;
    public static int UPGRADE   =3;
    public static Map<String,Integer> dict = new HashMap<String,Integer>();
    public static ArrayList<Node> tree_arr = new ArrayList<Node>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noofnode = Integer.parseInt(br.readLine());
//        System.out.println(noofnode);
        int noofchildren = Integer.parseInt(br.readLine());
//        System.out.println(noofchildren);
        int noofquery = Integer.parseInt(br.readLine());
//        System.out.println(noofquery);
        for (int i = 0; i < noofnode; i++) {
//            System.out.print("Enter "+i+" value:");
            String str = br.readLine();
            dict.put(str,i);
            Node t= new Node(i,noofchildren);
            tree_arr.add(t);
        }
        for (int i = 0; i < noofquery; i++) {
//        System.out.println("Enter query 1");
            String arr[] = br.readLine().split(" ");
            int operation = Integer.parseInt(arr[0]);
            Node node =  tree_arr.get(dict.get(arr[1]));
            int userid = Integer.parseInt(arr[2]);
//            System.out.println("enter perfrom fucntion:");
            String res =  perform(operation,node,userid);
            System.out.println(res);
        }

    }

}

