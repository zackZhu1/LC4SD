// Two sum: how many pairs sum == target
// 0. sorted array, no duplicate
private static int test1(int[] array, int target) {
	int count = 0;
	int left = 0;
	int right = array.length - 1;
	while (left < right) {
		int sum = array[left] + array[right];
		if (sum == target) {
			count++;
			left++;
			right--;
		} else if (sum < target) {
			left++;
		} else {
			right--;
		}
	}
	return count;
}

// 1. sorted array, have duplicates, but don't count duplicate pairs
private static int test2(int[] array, int target) {
	int count = 0;
	
	int left = 0;
	int right = array.length - 1;
	while (left < right) {
		int sum = array[left] + array[right];
		if (sum == target) {
			System.out.println(array[left] + " " + array[right]);
			count++;
			while (left < right && array[right] == array[right - 1]) { // skip all the same elements
				right--;
			}
			right--;
		} else if (sum < target) {
			left++;
		} else {
			right--;
		}
	}
	return count;
}

// 2. sorted array, have duplicates, count duplicate pairs
private static int test4(int[] array, int target) {
	int count = 0;
	int left = 0;
	int right = array.length - 1;
	
	while (left < right) {
		int sum = array[left] + array[right];
		if (sum == target) {
			if (array[left] == array[right]) {
				count += (right - left + 1) * (right - left) / 2;
				break;
			}
			
			int rightCount = 1;
			int leftCount = 1;
			while (array[left] == array[left + 1]) {
				leftCount++;
				left++;
			}
			
			while (array[right] == array[right - 1]) {
				rightCount++;
				right--;
			}
			
			left++;
			right--;
			
			count += leftCount * rightCount;
		} else if (sum < target) {
			left++;
		} else {
			right--;
		}
	}
	return count;
}


// 3. unsorted array, have duplicates, count duplicate pairs
private static int test5(int[] array, int target) {
	int count = 0;
	HashMap<Integer, Integer> map = new HashMap<>();
	for(int j = 0; j < array.length; j++) {
		count += map.getOrDefault(target - array[j], 0);
		map.put(array[j], map.getOrDefault(array[j], 0) + 1);
	}
	return count;
}



