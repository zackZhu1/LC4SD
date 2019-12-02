class Solution {
    public int fixedPoint(int[] A) {
        // sanity check
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == mid) {
                right = mid;
            } else if (A[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return A[left] == left ? left : -1;
    }
}

// if A[mid] < mid, prove A[mid - 1] < mid - 1
// A[mid - 1] <= A[mid] - 1 < mid - 1 < mid