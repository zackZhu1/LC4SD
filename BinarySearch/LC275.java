class Solution {
    public int hIndex(int[] citations) {
        
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int nums = citations.length - mid;
            if (citations[mid] == nums)
                return nums;
            else if (citations[mid] < nums)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return citations.length - left;
    }
}


// e.g. sorted array [0, 1, 3, 5, 6] (for each element x)
//       f(x) = x    [5, 4, 3, 2, 1] 
//  x ^  --> x is increasing, f(x) is decreasing
// find the largest x where f(x) >= x
