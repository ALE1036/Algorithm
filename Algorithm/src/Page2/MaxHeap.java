package Page2;

public class MaxHeap<T extends Comparable<T>> {

	private T[] data;

	private int count;

	private int capacity;

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		data = (T[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}

	public MaxHeap(T[] arr,int n) {
		data = (T[]) new Comparable[n + 1];
		capacity = n;
		for (int i = 0; i < n; i++) {
			data[i+1] = arr[i];
		}
		count=n;
		
		for (int i = count/2; i >=1 ; i--) {
			 shiftDown(i);
		}
		
	}
	
	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(T item) {
		if (count + 1 < capacity) {
			data[count + 1] = item;
			count++;
			shifUp(count);
		}
	}

	public T extractMax() {
		if (count < 0) {
			return null;
		}

		T item = data[1];

		T tmp = data[1];
		data[1] = data[count];
		data[count] = tmp;
		count--;
		shiftDown(1);
		return item;
	}

	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k;
			if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
				j += 1;
			}
			if (data[k].compareTo(data[j]) >= 0) {
				break;
			}
			T tmp1 = data[k];
			data[k] = data[j];
			data[j] = tmp1;
			k = j;
		}
	}

	private void shifUp(int k) {

		while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
			T tmp = data[k / 2];
			data[k / 2] = data[k];
			data[k] = tmp;
			k /= 2;
		}

	}


	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}

}
