package Page1;

import java.lang.reflect.Field;

public class SortTestHelper {

	// 随机数的范围是[rangeL,rangeR]
	public Integer[] GenerateRandomArray(int n, int rangeL, int rangeR) {

		if (rangeL <= rangeR) {
			Integer arr[] = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = rangeL + (int) (Math.random() * (rangeR - rangeL + 1));
			}
			System.out.println("-----已生成随机生成数组-----");
			return arr;
		} else {
			return null;
		}

	}

	public Integer[] GenerateOrderlyArray(int n, int swaptime) {
		Integer arr[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < swaptime; i++) {
			int posy = (int) (Math.random() * n);
			int posx = (int) (Math.random() * n);
			// 进行随机交互
			int tmp = posy;
			arr[posy] = arr[posx];
			arr[posx] = arr[tmp];
		}
		System.out.println("-----已生成几乎有序数组-----");
		return arr;
	}

	public <T> Comparable[] copyArray(T[] arr) {

		Comparable[] copyArray = new Comparable[arr.length];

		for (int i = 0; i < arr.length; i++) {
			copyArray[i] = (Comparable) arr[i];
		}

		return copyArray;
	}

	public <T extends Comparable<T>> void printArray(T[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] != null) {
				System.out.print(arr[i] + "  ");
			}
		}
		System.out.println();
	}

	public <T extends Comparable<T>> boolean isSorted(T[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	public void swap(Integer i1, Integer i2) throws Exception {
		Field field = Integer.class.getDeclaredField("value");
		field.setAccessible(true);
		Integer tmp = new Integer(i1.intValue());
		field.set(i1, i2.intValue());
		field.set(i2, tmp);
	}

}
