package programCreek.stringsAndArrays;

/*  Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9) */

public class MinJumps{

    public static int minJumps(int[] A){
        // jumps[i] = min number of jums to reach A[n-1] from A[i]
        int[] jumps = new int[A.length];
        jumps[A.length - 1] = 0;
        for(int i = n-2; i >= 0; i--){
            if(A[i] == 0){
                jumps[i] = Integer.MAX_VALUE;
            }
            else if(A[i] > A.length - i - 1){
                jumps[i] = 1;
            }
            else{
                int min = Integer.MAX_VALUE;
                // check all points reachable from i
                for(int j  = i+1; i <= A.length && j <= A[i] + i; j++){
                    if(min > jumps[j]){
                        min = jumps[j];
                    }
                }
                if(min != Integer.MAX_VALUE){
                    jumps[i] = min + 1;
                }
                else{
                    jumps[i] = min;
                }
            }
        }


        return jumps[0];
    }
    

}
