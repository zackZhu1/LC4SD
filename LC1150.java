class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return false;
        }
        int mid = nums.length / 2;
        if (nums[mid] != target) return false;
        
        // find the first occurance of target
        int index = firstOccurance(nums, target);
        int lastIndex = index + nums.length / 2;
        
        if (lastIndex < nums.length && nums[lastIndex] == target) {
            return true;
        } else {
            return false;
        }
    }
    
    private int firstOccurance(int[] nums, int target) {
        int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// post-processing
		if (nums[left] == target) {
			return left;
		} else if (nums[right] == target) {
			return right;
		}
		return -1;
    }

    private int firstOccurance2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // post-processing
        if (nums[left] == target) return left;
        return -1;
    }
} 

// Note1: base case cannot be left <= right, it will cause endless loop
// Note2: [1, 2, 2, 2, 3]    N = 5 N/2 = 2
//        [1, 2, 2, 2, 2, 3] N = 6 N/2 = 3
//        because more than N / 2, so lastIndex = firstIndex + N / 2
