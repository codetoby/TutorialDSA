package Week4;
public class SelectionSort implements Sort {
    
    public void sort(int[] nums) {
        
        int n = nums.length;
        int smallestIndex;

        for (int i = 0; i < n; i++) {
            smallestIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[smallestIndex] > nums[j]) {
                    smallestIndex = j;
                }
            } 
            swap(nums, i, smallestIndex);
        }
    }

}
