// solution1: quick select
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = findIndex(nums, nums.length - k, 0, nums.length - 1);
        return nums[index];
    }
    
    private int findIndex(int[] nums, int index, int left, int right) {
        int pivot = partition(nums, left, right);
        if (pivot == index) {
            return pivot;
        } else if (pivot < index) {
            return findIndex(nums, index, pivot + 1, right);
        } else {
            return findIndex(nums, index, left, pivot - 1);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (nums[start]< pivot) {
                start++;
            } else if (nums[end] > pivot) {
                end--;
            } else {
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// e.g. [1, 2, 3, 4, 5, 6] k = 2
// the target index = nums.length - k = 6 - 2 = 4
// Time: best case O(n)  worst case O(n^2)
// Space: O(1)