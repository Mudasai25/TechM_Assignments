package threads;
import java.util.Arrays;
class Sort extends Thread {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
    }

    public int[] getSortedArray() {
        return arr;
    }
}
public class thread1 {
	
	 public static void main(String[] args) {
	        int[] array = {9, 10, 7, 2, 8, 5, 1, 6, 4};

	        int mid = array.length / 2;
	        int[] first = Arrays.copyOfRange(array, 0, mid);
	        int[] second = Arrays.copyOfRange(array, mid, array.length);

	        Sort thread1 = new Sort(first);
	        Sort thread2 = new Sort(second);

	        thread1.start();
	        thread2.start();

	        try {
	            thread1.join();
	            thread2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        int[] sortedArray = merge(thread1.getSortedArray(), thread2.getSortedArray());
	        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
	    }

	    private static int[] merge(int[] arr1, int[] arr2) {
	        int[] merged = new int[arr1.length + arr2.length];
	        int i = 0, j = 0, k = 0;

	        while (i < arr1.length && j < arr2.length) {
	            if (arr1[i] < arr2[j]) {
	                merged[k++] = arr1[i++];
	            } else {
	                merged[k++] = arr2[j++];
	            }
	        }

	        while (i < arr1.length) {
	            merged[k++] = arr1[i++];
	        }

	        while (j < arr2.length) {
	            merged[k++] = arr2[j++];
	        }

	        return merged;
	    }
}
	


