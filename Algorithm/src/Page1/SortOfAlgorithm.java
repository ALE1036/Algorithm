package Page1;

public class SortOfAlgorithm {

	public static <T extends Comparable<T>> void selectionSort(T[] arr, Integer n) {

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) { // 寻找[i,n)区间的最小值
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			/* swap(arr[i], arr[minIndex]); */
			T tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}

	}

	public <T extends Comparable<T>> void insertionSort(T[] arr, Integer n) {
		for (int i = 1; i < n; i++) {
			T e = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = e;
		}
	}

	private <T extends Comparable<T>> void insertionSort02(T[] arr, Integer left, Integer right) {
		for (int i = left; i <= right; i++) {
			T e = arr[i];
			int j;
			for (j = i; j > left && arr[j - 1].compareTo(e) > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = e;
		}
	}

	public <T extends Comparable<T>> void mergeSortBU(T[] arr, Integer n) {

		for (int sz = 1; sz <= n; sz += sz) {
			for (int i = 0; i + sz < n; i += sz + sz) {
				// 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
				int asz = i + sz + sz - 1 > n - 1 ? n - 1 : i + sz + sz - 1;
				merge(arr, i, i + sz - 1, asz);
			}
		}
	}

	public <T extends Comparable<T>> void mergeSort(T[] arr, Integer n) {

		mergeSortOf(arr, 0, n - 1);
	}

	// 递归使用归并排序，对arr[left...right]的范围进行排序
	private <T extends Comparable<T>> void mergeSortOf(T[] arr, int left, int right) {
		// if (left >= right) { return; }
		if (right - left <= 20) {
			insertionSort02(arr, left, right);
			return;
		}

		int mid = (left + right) / 2;
		mergeSortOf(arr, left, mid);
		mergeSortOf(arr, mid + 1, right);
		// merge(arr, left, mid, right);
		if (arr[mid].compareTo(arr[mid + 1]) > 0) {
			merge(arr, left, mid, right);
		}
	}

	// 将arr[left...mid]和arr[mid+1...right]两部分进行归并
	private <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {

		T[] aux = (T[]) new Comparable[right - left + 1];

		for (int i = left; i <= right; i++) {
			aux[i - left] = arr[i];
		}

		int i = left, j = mid + 1;
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				arr[k] = aux[j - left];
				j++;
			} else if (j > right) {
				arr[k] = aux[i - left];
				i++;
			} else if (aux[i - left].compareTo(aux[j - left]) < 0) {
				arr[k] = aux[i - left];
				i++;
			} else {
				arr[k] = aux[j - left];
				j++;
			}
		}

	}

	public <T extends Comparable<T>> void quickSort(T[] arr, Integer n) {

		quickSortOf(arr, 0, n - 1);
		System.out.println("quickSortOfEND");
	}

	private <T extends Comparable<T>> void quickSortOf(T[] arr, int left, int right) {

		if (right - left <= 20) {
			insertionSort02(arr, left, right);
			return;
		}

		/*
		 * if(left>=right){ return; }
		 */

		int p = partition(arr, left, right);
		quickSortOf(arr, left, p - 1);
		quickSortOf(arr, p + 1, right);
	}

	// 返回的P,使得arr[left...p-1] < arr[p] ; arr[p+1...r] > arr[p]
	private <T extends Comparable<T>> int partition(T[] arr, int left, int right) {

		int a = (int) (Math.random() * (right - left + 1) + left);
		T tmp = arr[a];
		arr[a] = arr[left];
		arr[left] = tmp;

		T v = arr[left];
		int j = left; // arr[l+1...j] <v ;arr[j+1...i)>v
		for (int i = left + 1; i <= right; i++) {
			if (arr[i].compareTo(v) < 0) {
				T tmp1 = arr[j + 1];
				arr[j + 1] = arr[i];
				arr[i] = tmp1;
				j++;
			}
		}
		T tmp2 = arr[left];
		arr[left] = arr[j];
		arr[j] = tmp2;

		return j;
	}

	public <T extends Comparable<T>> void quickSort2(T[] arr, Integer n) {

		quickSortOf2(arr, 0, n - 1);
	}

	private <T extends Comparable<T>> void quickSortOf2(T[] arr, int left, int right) {
		if (right - left <= 20) {
			insertionSort02(arr, left, right);
			return;
		}

		int p = partition2(arr, left, right);
		quickSortOf2(arr, left, p - 1);
		quickSortOf2(arr, p + 1, right);

	}

	private <T extends Comparable<T>> int partition2(T[] arr, int left, int right) {

		int a = (int) (Math.random() * (right - left + 1) + left);
		T tmp = arr[a];
		arr[a] = arr[left];
		arr[left] = tmp;

		T v = arr[left];

		int i = left + 1, j = right;
		while (true) {
			while (i <= right && arr[i].compareTo(v) < 0) {
				i++;
			}
			while (j >= left + 1 && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			T emp = arr[i];
			arr[i] = arr[j];
			arr[j] = emp;
			i++;
			j--;
		}
		T emp1 = arr[left];
		arr[left] = arr[j];
		arr[j] = emp1;
		return j;
	}

	public <T extends Comparable<T>> void quickSort3Ways(T[] arr, Integer n) {

		quickSortOf3Ways(arr, 0, n - 1);
	}

	private <T extends Comparable<T>> void quickSortOf3Ways(T[] arr, int left, int right) {

		if (right - left <= 30) {
			insertionSort02(arr, left, right);
			return;
		}

		// partition过程
		int a = (int) (Math.random() * (right - left + 1) + left);
		T tmp = arr[a];
		arr[a] = arr[left];
		arr[left] = tmp;

		T v = arr[left];

		int lt = left;  //arr[left+1...lt] < v
		int gt = right + 1;  //arr[gt-1...r] > v
		int i = left + 1;  //arr[left+1...i] == v
		
		while (i < gt) {
			if (arr[i].compareTo(v) < 0) {
				T tmp2 = arr[i];
				arr[i] = arr[lt + 1];
				arr[lt + 1] = tmp2;
				lt++;
				i++;
			} else if (arr[i].compareTo(v) > 0) {
				T tmp3 = arr[i];
				arr[i] = arr[gt - 1];
				arr[gt - 1] = tmp3;
				gt--;
			}else{
				i++;
			}
		}
		T tmp4 = arr[left];
		arr[left] = arr[lt];
		arr[lt] = tmp4;
		
		quickSortOf3Ways(arr,left,lt-1);
		quickSortOf3Ways(arr,gt,right);
	}

}
