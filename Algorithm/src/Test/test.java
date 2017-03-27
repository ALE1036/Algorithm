package Test;

public class test {
	
	public<T extends Comparable<T>> void add(T[] arr,Integer b){
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println(b);
	}
	
}
