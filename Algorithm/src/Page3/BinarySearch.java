package Page3;

public class BinarySearch {

	public <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {
		int left = 0, right = n - 1;
		while (left <= right) {

			// int mid = (left + right) / 2;
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (target.compareTo(arr[mid]) < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return -1;
	}

}
