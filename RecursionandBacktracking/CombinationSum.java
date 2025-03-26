import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum {
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        findCombinationSum(0, arr, target, list, new ArrayList<>());
        return list;
    }
    static void findCombinationSum(int index, int[] nums, int target, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> ds){
        if(index == nums.length) {
            if(target == 0){
                output.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index] <= target){
            ds.add(nums[index]);
            findCombinationSum(index, nums, target - nums[index], output, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinationSum(index + 1, nums, target, output, ds);

    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        int target = 8;

        ArrayList<ArrayList<Integer>> res = combinationSum(arr, target);

        for (ArrayList<Integer> v : res) {
            for (int i : v) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
}
}