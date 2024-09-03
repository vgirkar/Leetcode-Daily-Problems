// Suppose you are given a sorted array of unknown length and a number to search for, 
//return the index of the number. Accessing an element out of bounds throws exception. If the number occurs multiple times, 
//return the index of any occurrence. If it isn’t present, return -1. 



public class Unknown {
    interface ArrayReader{
        public int get(int index);
    }
   public int search(ArrayReader reader, int target){
    int high = 1;
    while(reader.get(high) != Integer.MAX_VALUE){
        high *= 2;
    }


    return binarySearch(reader, target, 0, high);

   }

   private int binarySearch(ArrayReader reader, int target, int low, int high){
    while(low <= high) {
        int mid = low + (high - low)/2;
        if(reader.get(mid) == target){
            return mid;
        }
        else if(reader.get(mid) > target) {
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    return -1;
   }
    public static void Main(String[] args){
        int[] secret = {-1,0,3,5,9,12};
        int target = 9;

    }
    
}
