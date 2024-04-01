package Week4;

public class MergeSort implements Sort {


    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right ) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int[] sortedPart = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                sortedPart[index] = nums[i];
                i++;
                index++;
            } else {
                sortedPart[index] = nums[j];
                j++;
                index++;
            }
        }

        if (i <= mid) {
            sortedPart[index] = nums[i];
            index++;
            i++;
        }

        if (j <= right) {
            sortedPart[index] = nums[j];
            index++;
            j++;
        }

        for (int k = left; k < right; k++) {
            nums[k] = sortedPart[k - left];
        }
    }


    
}
