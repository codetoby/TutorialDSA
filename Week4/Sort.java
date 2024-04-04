package Week4;

import java.util.Arrays;

public interface Sort {
    void sort(int[] nums);
    default void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    default void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
