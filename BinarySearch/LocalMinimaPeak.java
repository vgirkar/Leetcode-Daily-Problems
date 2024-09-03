//Question: Given an array 'nums' of size 'n' where n >= 1, find the local minimum, which is an index 'i' such that
//1) nums[i] < nums[i-1] (if i > 0)
//2) nums[i] < nums[i+1] (if i < n -1)
// Time Complexity: (O(logn))

public class LocalMinimaPeak {
    public int findLocalMinimum(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(mid > 0 && nums[mid] > nums[mid - 1]){
                right = mid - 1;
            }
            else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return left;
    }
//Time Complexity : O(N);
    public int findLocalMinimumBruteForce(int[] nums){
        int n = nums.length;

        if(n == 1) return 0;

        if (nums[0] < nums[1]) return 0;

        if(nums[n-1] < nums[n-2]) return n - 1;

        for(int i = 0; i < n -1; i++){
            if(nums[i] < nums[i - 1] && nums[i] < nums[i + 1]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LocalMinimaPeak finder = new LocalMinimaPeak();

        int[] nums = {9, 6, 3, 14, 5, 7, 4};

        int x = finder.findLocalMinimum(nums);
        System.out.println("Local Minimum Index : " + x);

        int y = finder.findLocalMinimumBruteForce(nums);
        System.out.println("Local Minimum Index : " + y);
    }

    
}
