
public class Solution {

    public int size;

    public int[] searchRange(int[] nums, int target) {

        size = nums.length;

        int left = searchForLeftBoundary(nums, 0, size - 1, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }

        int right = searchForRightBoundary(nums, left, size - 1, target);

        return new int[]{left, right};
    }

    public int searchForLeftBoundary(int[] nums, int left, int right, int target) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] < target)) {
                return mid;
            }

            if (nums[mid] > target || nums[mid] == target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int searchForRightBoundary(int[] nums, int left, int right, int target) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target && (mid + 1 == size || nums[mid + 1] > target)) {
                return mid;
            }

            if (nums[mid] < target || nums[mid] == target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
