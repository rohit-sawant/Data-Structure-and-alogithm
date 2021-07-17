package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class NearestMeetingCell {
    public static int solution(int[] arr,int n,int i,int j){
        boolean end = false;
        boolean iscycle = false;
        int num1=i,num2 =j,k=i;
        boolean indexlast  = false;
        int minusindex = 0;
        for(int ij=0;ij<n;ij++){
            if(arr[ij]==n){
                indexlast = true;
                minusindex = 1;
            }
        }
        if(num1==n||num2==n){
            return -1;
        }
        System.out.print(minusindex);
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        ArrayList<Integer> cycle = new ArrayList<>();
        while(  arr[k-minusindex]!=-1 && arr[k-minusindex]!=num1 && !cycle.contains(k)){
            cycle.add(k);
            k = arr[k-minusindex];
            if(arr[k-minusindex]==num1){
                cycle.add(k);
                iscycle = true;
                break;
            }
        }
        while(arr[i-minusindex]!=num2 && arr[i-minusindex]!=-1 && !path1.contains(i)){
            path1.add(i);
            i = arr[i-minusindex];
            if(arr[i-minusindex]==num2 || arr[i-minusindex]==num1||arr[i-minusindex]==-1){
                path1.add(i);
                break;
            }
        }
//        if(arr[i]==num2){
//            path1.add(num2);
//        }
//        System.out.print(arr[j-minusindex]);
        while( arr[j-minusindex]!=num1 && arr[j-minusindex]!=-1 && !path1.contains(j) && !path2.contains(j)){
            path2.add(j);
            j = arr[j-minusindex];
            if(path1.contains(j)){
                break;
            }
            if(arr[j-minusindex]==num1||arr[j-minusindex]==num2||arr[j-minusindex]==-1){
                path2.add(j);
                end = true;
                break;
            }

        }
        System.out.println(cycle+" "+path1+"   "+path2);
        if(iscycle && cycle.contains(num1) && cycle.contains(num2))
        {
            return num2;
        }
        if(end){
           return -1;
        }
        if(path1.isEmpty()){
            return  -1;

        }
        if(path2.isEmpty()){
            return -1;
        }
        return j;

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
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println("\n"+solution(array,numOfBlocks,i,j));
        }
        scanner.close();
    }
}

