package Week3;

public class BiSect {

    public static int bijectLeft(int[] nums, int num) {

        int low = 0 ;
        int high = nums.length -1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < num){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    public static int bijectRight(int[] nums, int num) {

        int low = 0, high = nums.length -1;

        while (low <  high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= num){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int num = 4;
        int[] nums = {1, 2, 3, 4, 6};
        System.out.println(bijectRight(nums, num));
     }
    
}
