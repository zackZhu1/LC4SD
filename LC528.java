class Solution {
	private int[] psum;
    private int totalWeights = 0;
    private Random random;
    
    public Solution(int[] w) {
        this.random = new Random();
        this.psum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            totalWeights += w[i];
            psum[i] = totalWeights;
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(totalWeights);
        int left = 0;
        int right = psum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < psum[mid]) {
                right = mid;
            } else if (target >= psum[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}

// e.g. w = [1, 3, 2, 5] --> totalweights = 11
//    sum = [1,   4,   6,      11] 
//         0  123   45   678910     --> find first element > target

