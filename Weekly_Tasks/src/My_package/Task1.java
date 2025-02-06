package My_package;
import java.util.*;
public class Task1 {
	public static void main(String[] args) {
		int array1[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int array2[] = { 100,200,300,400,500,600,700,800,900};
		int j=0;
		for(int i=1;i<array2.length;i=i+2) {
				System.arraycopy(array1, j++, array2, i, 1);
		}
		
		System.out.println(Arrays.toString(array2));
		
		
	}
}
