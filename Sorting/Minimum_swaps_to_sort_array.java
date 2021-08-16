
class Pair implements Comparable<Pair>{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
    public int compareTo(Pair obj){
        if(this.first>obj.first) return 1;
        else if(this.first<obj.first) return -1;
        return 0;   
    }
    public String toString(){
       return "{"+this.first+","+this.second+"}";
    }
}
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int count= 0;
        List<Pair> arr= new ArrayList<Pair>();
        for(int i=0;i<nums.length;i++){
            arr.add(new Pair(nums[i],i));
        }
        Collections.sort(arr);
        
        for(int i=0;i<nums.length;i++){
            if(arr.get(i).second!=i){
               Pair temp = arr.get(i);
               arr.set(i,arr.get(temp.second));
               arr.set(temp.second,temp);
               i--;
               count++;
            }
             
        }
        return count;
    }
}
