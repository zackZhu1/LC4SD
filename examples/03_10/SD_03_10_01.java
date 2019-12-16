package code;
import java.util.*;

public class test {
	
	private static void heapSort(int[] array) {
		// sanity check
		if (array == null || array.length == 0) return;
		
		// step1: heapify
		heapify(array);
		// step2: use the length of the heap to conduct for loop
		for (int size = array.length - 1; size > 0; size--) {
			swap(array, 0, size);
			percolateDown(array, 0, size);
		}
	}
	
	private static void heapify(int[] array) {
		int startIdx = (array.length / 2) - 1;
		for (int i = startIdx; i >= 0; i--) {
			percolateDown(array, i, array.length);
		}
	}
	
	private static void percolateDown(int[] array, int index, int len) {
		while (index < len) {
			int max = index;
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			if (left < len && array[left] > array[max]) {
				max = left;
			}
			if (right < len && array[right] > array[max]) {
				max = right;
			}
			if (max == index)
				break;
			swap(array, index, max);
			index = max;
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {6, 5, 7, 4, 3, 1, 2};
		heapSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}



