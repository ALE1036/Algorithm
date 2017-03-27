package Page2;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

import Page1.SortOfAlgorithm;
import Page1.SortTestHelper;

public class HeapBase {

	public static void main(String[] args) throws Exception {

		int n = 1000000, swaptime = 1000;
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(n);
		SortTestHelper sth = new SortTestHelper();

	//	Integer[] arr1 = sth.GenerateRandomArray(n, 0, n);
		Integer[] arr1 = sth.GenerateOrderlyArray(n, swaptime);

		Comparable[] arr2 = sth.copyArray(arr1);
		Comparable[] arr3 = sth.copyArray(arr1);
		Comparable[] arr4 = sth.copyArray(arr1);
		Comparable[] arr5 = sth.copyArray(arr1);

		performanceTest(SortOfAlgorithm.class, "quickSort3Ways", arr2, n);
		performanceTest(Heapify.class, "heapSort1", arr3, n);
		performanceTest(Heapify.class, "heapSort2", arr4, n);
		performanceTest(Heapify.class, "heapSort3", arr5, n);
		System.out.println(sth.isSorted(arr4, n));
	}

	public static <T extends Comparable<T>> void performanceTest(Class<?> clazz, String name, T[] arr, int n)
			throws Exception {

		double start = System.currentTimeMillis();

		Method str = clazz.getMethod(name, arr.getClass(), Integer.class);
		str.invoke(clazz.newInstance(), arr, n);

		double end = System.currentTimeMillis();

		double time = (end - start) / 1000;

		DecimalFormat df = new DecimalFormat("###.00000");
		df.format(time);
		System.out.println(str.getName() + ": " + time + "√Î");

	}

}
