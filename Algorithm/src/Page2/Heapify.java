package Page2;

public class Heapify {

	public <T extends Comparable<T>> void heapSort1(T arr[], Integer n) {

		MaxHeap<T> maxheap = new MaxHeap<T>(n);
		for (int i = 0; i < n; i++) {
			maxheap.insert(arr[i]);
		}

		for (int i = n - 1; i >= 0; i--) {
			arr[i] = maxheap.extractMax();
		}

	}

	public <T extends Comparable<T>> void heapSort2(T arr[], Integer n) {

		MaxHeap<T> maxheap = new MaxHeap<T>(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = maxheap.extractMax();
		}

	}

	public <T extends Comparable<T>> void heapSort3(T arr[], Integer n) {

		// MaxHeap<T> maxheap = new MaxHeap<T>(arr,n);
		for (int i = (n - 1) / 2; i >= 0; i--) {
			shiftDown(arr, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			T tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			shiftDown(arr, i, 0);
		}

	}

	private <T extends Comparable<T>> void shiftDown(T[] arr, int n, int k) {

		while (2 * k +1 < n) {
			int j = 2 * k +1;
			if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
				j += 1;
			}
			if (arr[k].compareTo(arr[j]) >= 0) {
				break;
			}
			T tmp1 = arr[k];
			arr[k] = arr[j];
			arr[j] = tmp1;
			k = j;
		}
		
	}

}
