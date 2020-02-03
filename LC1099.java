class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int res = -1;
        while (i < j) {
            if (A[i] + A[j] >= K) {
                j--;
            } else {
                res = Math.max(res, A[i] + A[j]);
                i++;
            }
        }
        return res;
    }
}