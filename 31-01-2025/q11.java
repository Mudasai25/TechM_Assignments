package intro;
import java.util.Scanner;
public class q11 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String str = scanner.nextLine();
	        str = str.toLowerCase(); 
	        char smallestVowel = Character.MAX_VALUE; 

	        for (char ch : str.toCharArray()) {
	            if ("aeiou".indexOf(ch) != -1) { 
	                if (ch < smallestVowel) { 
	                    smallestVowel = ch;
	                }
	            }
	            
	        }
	        System.out.println(smallestVowel);
	        
	 }
}
