package Sample;
import java.util.*;

public class Assign_LastChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the input string
        String input = sc.nextLine();
        
        // Split the string into words based on spaces
        String[] words = input.split("\\s+");
        
        // String to store the result
        String result = "";
        
        // Iterate through each word
        for (String word : words) {
            // Check if the word is non-empty and the last character is a letter
            if (word.length() > 0 && Character.isLetter(word.charAt(word.length() - 1))) {
                result += word.charAt(word.length() - 1);  // Append the last character if it's a letter
            }
        }
        
        // Print the final result
        System.out.println(result);
    }
}
