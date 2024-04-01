package Week4;

public class BubbleSort implements Sort {

    public void sort(int[] nums) {
        int n = nums.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swapped = true;
                }
            }
        }
    }
}
