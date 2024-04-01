package Week4;

import java.util.Arrays;

public class RunSort {
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 9, 8, 3, 2, 1, 11, -4, -2, 1, 3, 100};

        System.out.print("Unordered: ");
        printNums(nums);

        Sort sort = new QuickSort();
        sort.sort(nums);

        System.out.print("Ordered: ");
        printNums(nums);
        
    }
    private static void printNums(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
