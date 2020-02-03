class Solution {
    public int triangleNumber(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        
        int total = 0;
        for (int k = 2; k < nums.length; k++) {
            int i = 0;
            int j = k - 1;
            while (i < j) { // find pairs of two sum >= target (k)
                int sum = nums[i] + nums[j];
                if (sum <= nums[k]) {
                    i++;
                } else {
                    total += j - i;
                    j--;
                }
            }      
        }
        return total;
    }
}