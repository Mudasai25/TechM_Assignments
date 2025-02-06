package Sample;

public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]=new int[10];
		int arr2[]=new int[5];
		System.out.println("Original Array");
		for (int i = 0; i < 10; i++) {
            arr1[i] = i + 1;
        }
		for (int k = 0; k < 10; k++) {
			System.out.println(arr1[k]+" ");
        }
		for(int i=0;i<5;i++) {
			System.arraycopy(arr1, i*2, arr2, i, 1);
		}
		System.out.println("Copied Array");
		for(int j=0;j<5;j++) {
			System.out.println(arr2[j]+" ");
		}

	}

}
