package Week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2 {


    public static int sumOfUniqueElementsOptimized(int[] array) {

        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = new HashSet<>();

        for (int num : array) {
            if (duplicateElements.contains(num)) {
                uniqueElements.remove(num);
            } else {
                duplicateElements.add(num);
                uniqueElements.add(num);
            }
        }
        int sum = 0;
        for (int num: uniqueElements) {
            sum += num;
        }
        return sum;

    }

    public static int sumOfUniqueElementsHashMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); 
            } else {
                map.put(num, 1);
            }
        }
        int sum = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, -1, 2, 3, 5};
        int sum = sumOfUniqueElementsHashMap(nums);
        System.out.println(sum);    
    }


}
