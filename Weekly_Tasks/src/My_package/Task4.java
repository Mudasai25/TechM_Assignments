package My_package;
import java.util.Arrays;
public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,40,50,60,70,80,90,100};
		
		int[] dest1=Arrays.copyOfRange(arr, 0, arr.length-2);
		int[] dest2=Arrays.copyOfRange(arr, 3, 8);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dest1));
		System.out.println(Arrays.toString(dest2));

	}

}
