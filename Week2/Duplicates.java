package Week2;

import java.util.HashMap;
import java.util.HashSet;

public class Duplicates {

    public static boolean hasKDuplicates(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count >= k) {
                    return true;
                }
                map.put(num, count);
            } else {
                map.put(num, 0);
            }
        }
        return false;
    }

    public static boolean hasDuplicates() {
        return false;
    }

    public static HashSet<Integer> getUnique(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!result.add(nums[i])) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4, 1, 2 , 3};
        System.out.println(getUnique(nums));
        // System.out.println(hasKDuplicates(nums, 3));
    }
    
}
