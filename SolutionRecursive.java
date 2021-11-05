
public class SolutionRecursive {

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

        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] < target)) {
                return mid;
            }

            if (nums[mid] > target || nums[mid] == target) {
                return searchForLeftBoundary(nums, left, mid - 1, target);
            }

            if (nums[mid] < target) {
                return searchForLeftBoundary(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    public int searchForRightBoundary(int[] nums, int left, int right, int target) {

        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target && (mid + 1 == size || nums[mid + 1] > target)) {
                return mid;
            }

            if (nums[mid] > target) {
                return searchForRightBoundary(nums, left, mid - 1, target);
            }

            if (nums[mid] < target || nums[mid] == target) {
                return searchForRightBoundary(nums, mid + 1, right, target);
            }
        }
        return -1;
    }
}
