package intro;
import java.util.Arrays;
public class task5 {
	  public static void main(String[] args) 
	  {
		  
	        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
	        int[][] array2 = {{1, 2, 3}, {4, 5, 6}};
	        
	       
	        System.out.println("Using equals(): " + array1.equals(array2));  // false

	       
	        System.out.println("Using deepEquals(): " + Arrays.deepEquals(array1, array2)); // true
	    }

}
