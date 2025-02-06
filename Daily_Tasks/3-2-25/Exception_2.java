package Sample;
import java.util.*;
public class Exception_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a digit");
		int number=sc.nextInt();
		        try {
		            checkEvenNumber(number); 
		        } catch (IllegalArgumentException e) {
		            System.out.println("Error: " + e.getMessage());
		        }
				sc.close();
		    }

		    public static void checkEvenNumber(int number) {
		        if (number % 2 != 0) {
		            throw new IllegalArgumentException(number + " is an odd number.");
		        }
		        System.out.println(number + " is an even number."); 
		    }
			

}
