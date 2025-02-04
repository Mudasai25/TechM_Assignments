package exceptionHandling;

public class exp3 {
	public static void main(String[] args) {
		int arr[]= {10,20,30,40};
		try {
			int no=arr[5];
			System.out.println(no);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out Of Bounds");
			//e.printStackTrace();
		}
		finally {
			System.out.println("Printing last element of array");
			System.out.println(arr[arr.length-1]);
		}
	}

}
