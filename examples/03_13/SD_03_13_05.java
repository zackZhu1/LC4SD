public void findCollections(int[] a, int[] b) {
	List<Integer> intersection = new ArrayList<>();
	List<Integer> union = new ArrayList<>();
	List<Integer> difference = new ArrayList<>();
	
	int i = 0;
	int j = 0;
	while (i < a.length && j < b.length) {
		if (a[i] == b[j]) {
			intersection.add(a[i]);
			union.add(a[i]);
			i++;
			j++;
		} else if (a[i] < b[j]) {
			union.add(a[i]);
			difference.add(a[i]);
			i++;
		} else {
			union.add(b[j]);
			difference.add(b[j]);
			j++;
		}
	}
	
	while (i < a.length) {
		union.add(a[i]);
		difference.add(a[i]);
		i++;
	}
	
	while (j < b.length) {
		union.add(b[j]);
		difference.add(b[j]);
		j++;
	}
}