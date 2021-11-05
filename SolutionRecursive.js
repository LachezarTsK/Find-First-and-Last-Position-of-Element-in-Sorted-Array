
var size;

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {

    size = nums.length;

    let left = searchForLeftBoundary(nums, 0, size - 1, target);
    if (left === -1) {
        return [-1, -1];
    }

    let right = searchForRightBoundary(nums, left, size - 1, target);

    return [left, right];
};

/**
 * @param {number[]} nums
 * @param {number} left
 * @param {number} right
 * @param {number} target
 * @return {number}
 */
function searchForLeftBoundary(nums, left, right, target) {

    if (left <= right) {

        let mid = Math.floor(left + (right - left) / 2);

        if (nums[mid] === target && (mid - 1 < 0 || nums[mid - 1] < target)) {
            return mid;
        }

        if (nums[mid] > target || nums[mid] === target) {
            return searchForLeftBoundary(nums, left, mid - 1, target);
        }

        if (nums[mid] < target) {
            return searchForLeftBoundary(nums, mid + 1, right, target);
        }
    }
    return -1;
}

/**
 * @param {number[]} nums
 * @param {number} left
 * @param {number} right
 * @param {number} target
 * @return {number}
 */
function searchForRightBoundary(nums, left, right, target) {

    if (left <= right) {

        let mid = Math.floor(left + (right - left) / 2);

        if (nums[mid] === target && (mid + 1 === size || nums[mid + 1] > target)) {
            return mid;
        }

        if (nums[mid] > target) {
            return searchForRightBoundary(nums, left, mid - 1, target);
        }

        if (nums[mid] < target || nums[mid] === target) {
            return searchForRightBoundary(nums, mid + 1, right, target);
        }
    }
    return -1;
}
