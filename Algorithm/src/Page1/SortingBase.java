package Page1;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class SortingBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {

		int n = 1000000 , swaptime = 100; 
		System.out.println("当前测试的随机量:"+n);
		SortTestHelper sth = new SortTestHelper();
		Integer[] arr0 = sth.GenerateRandomArray(n, 0, n);
	//	Integer[] arr1 = sth.GenerateOrderlyArray(n, swaptime);
		
		Comparable[] arr1 = sth.copyArray(arr0);
		Comparable[] arr2 = sth.copyArray(arr0);
		Comparable[] arr3 = sth.copyArray(arr0);
	
		performanceTest(SortOfAlgorithm.class,"mergeSort",arr1,n);
		performanceTest(SortOfAlgorithm.class,"quickSort2",arr2,n);
		performanceTest(SortOfAlgorithm.class,"quickSort3Ways",arr3,n);
		
		System.out.println(sth.isSorted(arr3, n));
		
	}
	
	
	public static <T extends Comparable<T>> void 
	 performanceTest(Class<?> clazz,String name,T[] arr, int n) 
			throws Exception{
		
		double start = System.currentTimeMillis();
		
		Method str = clazz.getMethod(name, arr.getClass(), Integer.class);
		str.invoke(clazz.newInstance(), arr, n);
		
		double end = System.currentTimeMillis();
		
		double time = (end - start)/1000;
		
		DecimalFormat df = new DecimalFormat("###.00000");
		df.format(time);
		System.out.println(str.getName()+": " + time +"秒"); 
	
	}

}
