class Solution {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                max = nums[i];
            } else if (nums[i] == max) {
                count ++;
            } else if (nums[i] != max) {
                count--;
            }
        }
        return max;
    }
}