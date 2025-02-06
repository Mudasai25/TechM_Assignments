package Sample;

public class Third_2 {

	public static void main(String[] args) {
		// single dimentinaol array
		int arr1[]=new int[10];
		int arr2[]=new int[5];
		for(int i=0;i<10;i=i+2) {
			System.arraycopy(arr1, i, arr2, i, 1);
		}

		for(int j=0;j<5;j++) {
			System.out.println(arr2[j]);
		}
	}

}
