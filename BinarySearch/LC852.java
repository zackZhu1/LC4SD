// 852. Peak Index in a Mountain Array
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        // sanity check
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // input array is definitely a mountain
    }
}