package Page3;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Page1.SortTestHelper;

public class BinarySearchBase {

	public static void main(String[] args) {
		int n = 10;
		SortTestHelper sth = new SortTestHelper();
		Integer[] arr1 = sth.GenerateRandomArray(n, 1, n);
		sth.printArray(arr1, n);
		// Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		// testSearch(map,arr1,n);

		BST bs = new BST();
		for (int i = 0; i < n; i++) {
			bs.insert(i, arr1[i]);
		}

		System.out.println(bs.seach(1));

	}

	public static void testSearch(Map<Integer, Integer> map, Integer[] arr, int n) {
		Set set = map.keySet();
		for (int i = 0; i < n; i++) {
			map.put(i, arr[i]);
		}
		System.out.print("key÷µ£∫");
		for (Object object : set) {
			System.out.print(object.toString() + " ");
		}
		System.out.println("\n");
		System.out.print("value÷µ£∫");
		for (int i = 0; i < n; i++) {
			System.out.print(map.get(i) + " ");
		}
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
