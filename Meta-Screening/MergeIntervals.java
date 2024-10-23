
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// // Problem Description:
// // You are given two sorted, non-overlapping interval lists list1 and list2.
//  Each list contains intervals of the form [start, end] where start <= end, 
// and the intervals are sorted by their start times. 
// Your task is to merge the two lists into a third list that contains the union of the intervals. 
// The result should also be a sorted, non-overlapping interval list.

// // Example:
// // text
// // Copy code
// // Input: 
// // list1 = [[1, 3], [5, 7], [8, 12]]
// // list2 = [[2, 4], [6, 8], [10, 15]]

// // Output:
// // [[1, 4], [5, 15]]


public class BFMergeIntervals {
    public static List<int []> mergeIntevals(int[][] list1, int[][] list2){
        //Combine both lists
        List<int[]> mergedList = new ArrayList<>();
        mergedList.addAll(Arrays.asList(list1));
        mergedList.addAll(Arrays.asList(list2));

        //Sort intervals by the start times
        mergedList.sort((a,b) -> Integer.compare(a[0], b[0]));

        //Result list for storing the merge intervals
        List<int[]> result = new ArrayList<>();

        //Iterate through the sorted intervals and merge overlapping ones
        for(int[] interval: mergedList){
            if(result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]){
                result.add(interval); // No overlap
            }
            else {
                //Overlapping intervals, merge them
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result;

    }

    public static List<int []> optimalMergeIntervals(int[][] list1, int[][] list2){
        List<int[]> result = new ArrayList<>();
        int i = 0; 
        int j = 0;
        int[] interval;
        while(i < list1.length && j < list2.length){
            if(list1[i][0] < list2[j][0]){
                interval = list1[i++];
            }
            else {
                interval = list2[j++];
            }
            merge(result, interval);

        }
        while(i < list1.length){
            merge(result, list1[i++]);
        }
        while(j < list2.length){
            merge(result, list2[j++]);
        }

        return result;

    }

    private static void merge(List<int[]> result, int[] interval){

        if(result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]){
            //No overlap
            result.add(interval);
        }
        else {
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
        }
    }

    public static void main(String args[]){
        int[][] list1 = {{1,3}, {5,7} , {8, 12}};
        int[][] list2 = {{2,4}, {6,8}, {10, 15}};

        // List<int[]> result = mergeIntevals(list1, list2);
        List<int[]> result = optimalMergeIntervals(list1, list2);

        //Print the result 
        for(int[] interval: result){
            System.out.println(Arrays.toString(interval));
        }
    }
    
}
