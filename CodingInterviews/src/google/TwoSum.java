package google;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
/* Given an array of integers, find two numbers such that they add up to a specific target number. */

public class TwoSum{
    public static int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> needed = new HashMap<Integer,Integer>();
        int[] res = {-1, -1};

        for(int i = 0; i < numbers.length; i++){
            // Check if the value numbers[i] completes sum to target
            if(needed.containsKey(numbers[i])){
                res[0] = needed.get(numbers[i]);
                res[1] = i;
                return res;
            }
            else{
                needed.put(target - numbers[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] numbers = {2,5,6,7,3,10,4};
        int[] sumToTwelve = twoSum(numbers, 12);
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println(String.format("The indices to sum to 12: ", sumToTwelve[0], sumToTwelve[1]));
        int[] sumToTen = twoSum(numbers, 10);
        System.out.println(String.format("The indices to sum to 10: ", sumToTen[0], sumToTen[1]));
    }

}
