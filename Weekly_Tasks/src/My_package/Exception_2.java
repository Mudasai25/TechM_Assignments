package My_package;
import java.util.*;
public class Exception_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a digit");
		int number=sc.nextInt();
		        try {
		            // Test the method with an odd number
		            checkEvenNumber(number); // This will throw an exception
		        } catch (IllegalArgumentException e) {
		            // Catch the exception and handle it
		            System.out.println("Error: " + e.getMessage());
		        }
		    }

		    // Method to check if a number is even
		    public static void checkEvenNumber(int number) {
		        if (number % 2 != 0) {
		            // Throw an exception if the number is odd
		            throw new IllegalArgumentException(number + " is an odd number.");
		        }
		        System.out.println(number + " is an even number."); // This line will execute only if the number is even
		    }

}
