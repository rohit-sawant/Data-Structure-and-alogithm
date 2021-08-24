
class Solution
{
    ArrayList<Integer> commonElements(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3) 
    {
        // code here 
    int i=0,j=0,k=0;
        
    ArrayList<Integer> al = new ArrayList<>();
    int prev1, prev2, prev3;
 
    // Initialize prev1, prev2,
    // prev3 with INT_MIN
    prev1 = prev2 = prev3 = Integer.MIN_VALUE;
 
    while (i < n1 && j < n2 && k < n3)
    {
         
        // If ar1[i] = prev1 and i < n1,
        // keep incrementing i
        while (i < n1 && ar1[i] == prev1)
            i++;
 
        // If ar2[j] = prev2 and j < n2,
        // keep incrementing j
        while (j < n2 && ar2[j] == prev2)
            j++;
 
        // If ar3[k] = prev3 and k < n3,
        // keep incrementing k
        while (k < n3 && ar3[k] == prev3)
            k++;
 
        if (i < n1 && j < n2 && k < n3)
        {
             
            // If x = y and y = z, print any of
            // them, update prev1 prev2, prev3
            // and move ahead in each array
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
            {
                al.add(ar1[i]);
                prev1 = ar1[i];
                prev2 = ar2[j];
                prev3 = ar3[k];
                i++;
                j++;
                k++;
            }
 
            // If x < y, update prev1
            // and increment i
            else if (ar1[i] < ar2[j])
            {
                prev1 = ar1[i];
                i++;
            }
 
            // If y < z, update prev2
            // and increment j
            else if (ar2[j] < ar3[k])
            {
                prev2 = ar2[j];
                j++;
            }
 
            // We reach here when x > y
            // and z < y, i.e., z is
            // smallest update prev3
            // and imcrement k
            else
            {
                prev3 = ar3[k];
                k++;
            }
        }
        
    }
    return al;
    }
}
