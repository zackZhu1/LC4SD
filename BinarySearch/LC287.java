class Solution {
    public int findDuplicate(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // define search range: [1, nums.length - 1]
        // f(x) = number of elements <= x (index starts from 1), f(x) is increasing
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

// requirement: Time < O(n^2), Space = O(1)
// e.g. [1, 2, 3, 3, 4] candidate: 1, 2, 3, 4
// solution1: for each candidate, do a linear scan   Time = O(N^2)
// solution2: linear scan one time, and use a hashmap to count number of elements Space = O(n)
// solution3: binary search: search range is not based on index but on range (https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code)