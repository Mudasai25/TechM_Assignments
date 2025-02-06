package Sample;
import java.util.Scanner;
public class Assign_Odd {

	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        
		        // Read the input string
		        String input = sc.nextLine();
		        
		        // String to store the characters at odd positions
		        String result = "";
		        
		        // Iterate through the string and pick characters at odd positions
		        for (int i = 0; i < input.length(); i++) {
		            if (i % 2 == 1) {  // Check if the position is odd (index is even)
		                result += input.charAt(i);  // Append the character to result
		            }
		        }
		        
		        // Print the result string
		        System.out.println(result);

	}

}
