// solution1: binary search
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
// Time = O(logn)

// solution2: quickSelect
public int hIndex(int[] array) {
    int left = 0, right = array.length - 1;
    int result = -1;
    while (left <= right) {
        int pivot = partition(array, left, right);
        int nums = array.length - pivot;
        if (array[pivot] == nums)
            return nums;
        else if (array[pivot] < nums)
            left = pivot + 1;
        else 
            right = pivot - 1;
    }
    return array.length - left;
}

private int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int start = left;
    int end = right - 1;
    while (start <= end) {
        if(array[start] < pivot) {
            start++;
        } else if (array[end] >= pivot) {
            end--;
        } else {
            swap(array, start++, end--);
        }
    }
    swap(array, start, right);
    return start;
}

private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
}
// Time = O(n)

// e.g. sorted array [0, 1, 3, 5, 6] (for each element x)
//       f(x) = x    [5, 4, 3, 2, 1] 
//  x ^  --> x is increasing, f(x) is decreasing
// find the largest x where f(x) >= x
