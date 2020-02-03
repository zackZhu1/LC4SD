public static boolean findValidTriangle(int[] a) {
	for (int k = 2; k < a.length; k++) {
		if (a[k - 1] + a[k - 2] > a[k]) {
			return true;
		}
	}
	return false;
}