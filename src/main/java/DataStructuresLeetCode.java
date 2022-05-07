import java.util.HashMap;

public class DataStructuresLeetCode {

    public static void main(String[] args){

        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        /* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. */
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!memo.containsKey(num)) memo.put(num, 1);
            else memo.put(num, memo.get(num) + 1);

            if (memo.get(num) > 1) return true;
        }

        return false;

    }
}
