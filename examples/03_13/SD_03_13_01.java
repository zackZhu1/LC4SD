public List<int[]> findLargestSumPairs(int[] a, int[] b, int target) {
	List<int[]> res = new ArrayList<>();
	
	Arrays.sort(a);
	Arrays.sort(b);
	int max = -1;
	int i = 0;
	int j = b.length - 1;
	
	while (i < a.length && j >= 0) {
		int sum = a[i] + b[j];
		if (sum <= target) {
			if (sum > max) {
				max = sum;
				
				int end_i = i;
				while (end_i < a.length - 1 && a[end_i + 1] == a[end_i]) {
					end_i++;
				}
				int a_count = end_i - i + 1;
				
				int start_j = j;
				while (start_j > 0 && b[start_j - 1] == b[start_j]) {
					start_j--;
				}
				int b_count = j - start_j + 1;
				
				res = new ArrayList<>();
				for (int k = 0; k < a_count * b_count; k++) {
					res.add(new int[] {a[i], b[j]});
				}					
			} 
				
			i++;
		} else {
			j--;
		}
	}
	return res;
}
