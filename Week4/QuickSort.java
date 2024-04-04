package Week4;

public class QuickSort implements Sort {
    
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = nums[(low + high) / 2];
        int index = partition(nums, low, high, pivot);
        quickSort(nums, low, index - 1);
        quickSort(nums, index, high);

    }

    private int partition(int[] nums, int low, int high, int pivot) {
        int i = low;
        int j = high;

        while (i <= j)  {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return i;
    }



}
