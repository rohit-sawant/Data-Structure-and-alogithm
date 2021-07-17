mport java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargestCycle {
    public  int solution(int[] arr,int n){
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i =0;i<n;i++){
            ArrayList<Integer> path = new ArrayList<>();
            int j = i;
            int t=0;
            while(arr[j]<arr.length && arr[j]!=-1 && arr[j]!=i && !path.contains(j)){
                path.add(j);
                t+=j;
                j = arr[j];
                if(arr[j]==i){
                    path.add(j);
                    t+=j;
                    break;
                }

            }
            System.out.print("index:"+i);
            if(j<arr.length && i==arr[j]){
                sum.add(t);
                System.out.print(" sum:"+t+" ->");
            }
            System.out.println(path);
        }
        if(sum.isEmpty())
            return -1;
        return Collections.max(sum);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int loop=0; loop<testCases; loop++) {
            int numOfBlocks = scanner.nextInt();
            int array[] = new int[numOfBlocks];
            int src, des;
            for (int i=0; i<numOfBlocks; i++) {
                array[i] = scanner.nextInt();
            }
            LargestCycle obj = new LargestCycle();

            System.out.println("\n"+obj.solution(array,numOfBlocks));
        }
        scanner.close();
    }
}
