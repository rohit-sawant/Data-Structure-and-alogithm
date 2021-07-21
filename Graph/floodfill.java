//Question link: https://leetcode.com/problems/flood-fill/
class Solution {
    class move{
        int a,b;
        move(int a,int b){
            this.a = a;
            this.b = b;
            
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int m = image.length;
            int n = image[0].length;
            boolean vis[][] = new boolean[m][n];
            vis[sr][sc] = true;
            int X[]={-1,1,0,0};
            int Y[]={0,0,1,-1};
            Queue<move> q = new LinkedList<>();
            int source = image[sr][sc];
            vis[sr][sc] =true;
            q.add(new move(sr,sc));
            while(!q.isEmpty()){
                move obj = q.poll();
//                downwards
                if(((obj.a)+1)<m){
                    int valuea = obj.a+1;
                    int valueb = obj.b;
                    if((!vis[valuea][valueb]) && image[valuea][valueb]==source){
                            vis[valuea][valueb] = true;
                            q.add(new move(valuea,valueb));
                            image[valuea][valueb] = newColor;
                    }
                }
//                upwards
                if(((obj.a)-1)>-1 ){
                    int valuea = obj.a-1;
                    int valueb = obj.b;
                    if((!vis[valuea][valueb]) && image[valuea][valueb]==source){
                        vis[valuea][valueb] = true;
                        q.add(new move(valuea,valueb));
                        image[valuea][valueb] = newColor;
                    }
                }
//                rightwards
                if(((obj.b)+1)<n){
                    int valuea = obj.a;
                    int valueb = obj.b+1;
                    if((!vis[valuea][valueb]) && image[valuea][valueb]==source){
                        vis[valuea][valueb] = true;
                        q.add(new move(valuea,valueb));
                        image[valuea][valueb] = newColor;
                    }
                }
//                leftwards
                if(((obj.b)-1)>-1){
                    int valuea = obj.a;
                    int valueb = obj.b-1;
                    if((!vis[valuea][valueb]) && image[valuea][valueb]==source){
                        vis[valuea][valueb] = true;
                        q.add(new move(valuea,valueb));
                        image[valuea][valueb] = newColor;
                    }
                }

            }
            image[sr][sc] = newColor;
            return image;
    }
    
}
