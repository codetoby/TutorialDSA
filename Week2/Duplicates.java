package Week2;

import java.util.HashMap;

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

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4, 1};
        System.out.println(hasKDuplicates(nums, 3));
    }
    
}
