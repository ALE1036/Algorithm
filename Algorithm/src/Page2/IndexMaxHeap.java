package Page2;

public class IndexMaxHeap<T extends Comparable<T>> {

	private T[] data;

	private int[] index;

	private int[] rev;

	private int count;

	private int capacity;

	@SuppressWarnings("unchecked")
	public IndexMaxHeap(int capacity) {
		data = (T[]) new Comparable[capacity + 1];
		index = new int[capacity + 1];
		rev = new int[capacity + 1];
		for (int i = 0; i <= capacity; i++) {
			rev[i] = 0;
		}
		count = 0;
		this.capacity = capacity;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(int i, T item) {
		if (count + 1 < capacity && i + 1 >= 1 && i + 1 <= capacity) {
			i += 1;
			data[i] = item;
			index[count + 1] = i;
			rev[i] = count + 1;
			count++;
			shifUp(count);
		}
	}

	public T extractMax() {
		if (count < 0) {
			return null;
		}

		T item = data[index[1]];

		int tmp = index[1];
		index[1] = index[count];
		index[count] = tmp;

		rev[index[1]] = 1;
		rev[index[count]] = 0;

		count--;
		shiftDown(1);
		return item;
	}

	public int extractMaxIndex() {
		if (count < 0) {
			return 0;
		}

		int item = index[1] - 1;

		int tmp = index[1];
		index[1] = index[count];
		index[count] = tmp;

		rev[index[1]] = 1;
		rev[index[count]] = 0;

		count--;
		shiftDown(1);
		return item;
	}

	private boolean contain(int i) {
		if (i + 1 >= 1 && i + 1 <= capacity) {
			return rev[i + 1] != 0;
		} else {
			return false;
		}
	}

	public T getItem(int i) {
		if (contain(i)) {
			return data[i + 1];
		}
		return null;
	}

	public void change(int i, T newItem) {
		if (!contain(i)) {
			return;
		}

		i += 1;
		data[i] = newItem;

		int j = rev[i];
		shiftDown(j);
		shifUp(j);
	}

	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k;
			if (j + 1 <= count && data[index[j + 1]].compareTo(data[index[j]]) > 0) {
				j += 1;
			}
			if (data[index[k]].compareTo(data[index[j]]) >= 0) {
				break;
			}
			int tmp1 = index[k];
			index[k] = index[j];
			index[j] = tmp1;

			rev[index[k]] = k;
			rev[index[j]] = j;
			k = j;
		}
	}

	private void shifUp(int k) {

		while (k > 1 && data[index[k / 2]].compareTo(data[index[k]]) < 0) {
			int tmp = index[k / 2];
			index[k / 2] = index[k];
			index[k] = tmp;

			rev[index[k / 2]] = k / 2;
			rev[index[k]] = k;
			k /= 2;
		}

	}

}
