package Sample;
import java.util.*;
public class TaskEquals {

	public static void main(String[] args) {
				int intArray1[] = {7, 2, 3};
				int intArray2[] = {1, 2, 3};
				Object[] arr1 = {intArray1};
				Object[] arr2 = {intArray2};
				
				if(Arrays.equals(arr1, arr2)) {
					System.out.println("Both are Equal");
				} else {
					System.out.println("Not Equal");
				}
				if(Arrays.deepEquals(arr1, arr2)) {
					System.out.println("Both are Deep Equal Arrays");
				} else {
					System.out.println("Not Deep Equals");
				}

			}
		}

