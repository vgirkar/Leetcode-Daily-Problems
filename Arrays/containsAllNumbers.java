//You are given an array of size 'n'. The task is to determine if this array contains all the integers form '0' to 'n-1';
// Input: An array of integers of size 'n';
//Output: A boolean value ('true' or 'false'), where 'true' indicates that the array contains all integers from
// '0' to 'n-1', and 'false' indicates that it does not.

import java.util.HashSet;
import java.util.Set;

public class containsAllNumbers {
    public static boolean containsAllNumbers(int[] arr){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int num: arr){
            if(num >= 0 && num < n){
                set.add(num);
                System.out.println("Added " + num + " to the set. Current set: " + set);

            } else {
                System.out.println("Number " + num + " is out of range.");
                return false;
            }
        }
        return set.size() == n;

    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};
        System.out.println(containsAllNumbers(arr));

        int[] arr2 = {0,1,3,4,5};
        System.out.println(containsAllNumbers(arr2));
    }
}
    
