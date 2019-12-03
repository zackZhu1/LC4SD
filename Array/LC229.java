class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0) {
            return result;
        }
        // only one element
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        } 
        
        // voting algorithm
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) 
                count1++;
            else if (nums[i] == candidate2)
                count2++;
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // recalculate the count for two candidates
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1)
                count1++;
            else if (nums[i] == candidate2)
                count2++;
        }
        
        if (count1 > nums.length / 3)
            result.add(candidate1);
        if (count2 > nums.length / 3)
            result.add(candidate2);
        return result;
    }
}

// more than n / 3
// Run time should be O(n) and Space should be O(1)
// e.g. [2, 2, 1, 3] note: recalculate again after voting ! 



