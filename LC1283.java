class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        return findSmallestDivisor(nums, threshold, 1, max);
    }
    
    private int findSmallestDivisor(int[] nums, int threshold, int min, int max) {
        while (max > min) {
            int divisor = (min + max) / 2;
            int sum = 0;
            for (int num : nums) {
                if (num % divisor == 0) 
                    sum += num / divisor;
                else
                    sum += num / divisor + 1;
            }
            
            if (sum > threshold) {
                min = divisor + 1;
            } else {
                max = divisor;
            }
        }
        return max;
    }
}

// e.g. nums = [1, 2, 5, 9], threshold = 6
// find the smallest d such that sum <= threshold
// d = 1 --> [1, 2, 5, 9] sum = 17 > 6
// d = 2 --> [1/2=1+1=2, 1, 5/2=2+1=3, 9/2=4+1=5] sum = 11 > 6
// ...
// d = 4 --> [1, 1, 2, 3] sum = 7 > 6 
// d = 5 --> [1, 1, 1, 2] sum = 5 <= 6
// the larger the d, the less the sum
//  https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/discuss/446595/Java-Binary-Search