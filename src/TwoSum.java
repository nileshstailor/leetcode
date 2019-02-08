import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 7, 11, 5};
        int target = 9;
       System.out.println("In Array format : " + Arrays.toString(TwoSum.inArrayFormat(nums, target)));

       System.out.println("In HashMap format : " + Arrays.toString(TwoSum.inHashMapFormat(nums, target)));
    }


    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

    O(n)
     */
    public static int[] inArrayFormat(int[] nums, int target) {

        //0,2,5,6,8,
        //0+2
        //0+5
        //0+6
        //0+8
        //2+5
        //2+6...


        // have a loop that goes through the array one by one
        for (int i=0; i<nums.length; i++) {
            // and an inner loop that traverses the remainder of the list
            for (int x=i+1; x<nums.length; x++ ) {
                if (target == (nums[x] + nums[i])) {
                    return new int[] {x, i};
                }
            }
        }
        return null;
    }

    // O(1)
    public static int[] inHashMapFormat(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length;i++) {
            int idxValue = nums[i];
            int hashMapKey = target - idxValue;

            // add key that will store the index
            if(!map.containsKey(idxValue)) {
                map.put(hashMapKey, i);
            } else {
                // if map has that value than that means we have found the other index
                return new int[]{i, map.get(idxValue)};
            }
        }
        return new int[] {-1, -1};
    }
}
