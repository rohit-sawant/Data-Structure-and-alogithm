class Solution
{
    class chess{
        int a,b;
        chess(int x,int y){
            this.a = x;
            this.b = y;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int vis[][] = new int[N+1][N+1];
            int X[]={1,-1,1,-1,2,-2,2,-2};
            int Y[]={2,2,-2,-2,1,1,-1,-1};
            int distance = 1;
            vis[KnightPos[0]][KnightPos[1]] = distance;
            Queue<chess> q = new LinkedList<>();
            q.add(new chess(KnightPos[0],KnightPos[1]));
            while(!q.isEmpty()){
                chess obj = q.poll();
                if(obj.a==TargetPos[0] && obj.b==TargetPos[1]){
                    return vis[TargetPos[0]][TargetPos[1]]-1;
                }
                for(int i=0;i<8;i++){

                    if((obj.a+X[i])<(N+1) && (obj.a+X[i])>0 && (obj.b+Y[i])<(N+1) && (obj.b+Y[i])>0){
                        int valuex = (obj.a+X[i]);
                        int valuey = (obj.b+Y[i]);
                        if(vis[(valuex)][(valuey)]==0)
                        {

                            q.add(new chess(valuex,valuey));
                            vis[(valuex)][(valuey)] = (vis[obj.a][obj.b]+1);

                        }

                    }

                }
            }
            return -1;
        
    }
}
