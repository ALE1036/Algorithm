
package Test;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import Page1.SortTestHelper;

public class fanshe {
	public static void main(String[] args) throws Exception {

		Comparable[] arr1 = new Comparable[6];

		// getMeth(test.class, "add", arr1, 100);

		test(1);
	}

	public static <T extends Comparable<T>> void getMeth(Class clazz, String name, T[] arr, Integer b)
			throws Exception {

		Method str = clazz.getMethod(name, arr.getClass(), Integer.class);

		str.invoke(clazz.newInstance(), arr, b);

	}

	public static void test(int a) {

		if (a > 100) {
			return;
		} else {
			test(++a);
			System.out.println("666");
			test(++a);
		}
		
	}

}
