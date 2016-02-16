import java.util.*;

public class SortTest {
	static long count;
	static float sum;
	public static void main(String [] args){
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;

		int size = Integer.parseInt(args[0]);
		
		Integer [] a = new Integer[size];
		Integer [] b = new Integer[size];
		
		for(int i = 0; i < size; i++){
			a[i] = b[i] = (int)(Math.random() * 100);
		}
		
		//Tests bubblesort
		sum = sum + (float)(endTime - startTime);
		printArray(a);
		count = 0;
		startTime = System.currentTimeMillis();
		bubblesort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		printArray(a);
		System.out.println("bubblesort took " + count + " moves to sort " + size + " items ");
		System.out.println("\t in: " + elapsedTime + " millesec \n");
		
		//restore array
		count = 0;
		for(int i = 0; i < size; i++){
			a[i] = b[i];
		}
		
		//tests insertsort
		sum = sum + (float)(endTime - startTime);
		printArray(a);
		count = 0;
		startTime = System.currentTimeMillis();
		insertSort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		printArray(a);
		System.out.println("Insert sort took " + count + " moves to sort " + size + " items ");
		System.out.println("\t in: " + elapsedTime + " millesec \n");
		
		//restore array
		count = 0;
		for(int i = 0; i < size; i++){
			a[i] = b[i];
		}
		
		//tests shellsort
		sum = sum + (float)(endTime - startTime);
		printArray(a);
		count = 0;
		startTime = System.currentTimeMillis();
		shellSort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		printArray(a);
		System.out.println("Shell sort took " + count + " moves to sort " + size + " items ");
		System.out.println("\t in: " + elapsedTime + " millesec \n");
		
		//restore array
		count = 0;
		for(int i = 0; i < size; i++){
			a[i] = b[i];
		}
		
		//Part 6 using Arrays.sort method
		sum = sum + (float)(endTime - startTime);
		printArray(a);
		count = 0;
		startTime = System.currentTimeMillis();
		Arrays.sort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		printArray(a);
		System.out.println("Arrays.sort sorted " + size + " items ");
		System.out.println("\t in: " + elapsedTime + " millesec ");
		
		
	}
	
	/**
	 * Prints array
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void printArray(AnyType [] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Sorts array using bubbleSort
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void bubblesort (AnyType [] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length - 1; j++){
				if(a[j].compareTo(a[j+1]) > 0){
						AnyType temp = a[j]; count++;
						a[j] = a[j+1]; count++;
						a[j+1] = temp; count++;
				}
			}
		}
	}
	
	/**
	 * Sorts array using insertSort
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType [] a){
		int j;
		for(int i = 1; i < a.length; i++){
			AnyType temp = a[i];
			for(j = i; j > 0 && temp.compareTo(a[j - 1]) < 0; j--){
				a[j] = a[j-1]; count++;
			}
			a[j] = temp; count++;
		}
	}
	
	/**
	 * Sorts array using shellSort with Hibbard's increments
	 * @param a
	 */
	public static <AnyType extends Comparable<? super Integer>> void shellSort(Integer [] a){
		int j = 1;
		int k = 0;
		while(j <= a.length + 1){
			for(int i = j; i < a.length; i++){
				Integer temp = a[i];
				j = i;
				while(k>=j && a[k-j]>temp){
					a[k] = a[k - j]; count++;
					k = k - j;
				}
			a[k] = temp; count++;
			}
		k = k + 1;
		j = (int)(java.lang.Math.pow(2, k)) - (int)1;
		}
	}
}
