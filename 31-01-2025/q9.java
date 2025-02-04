package intro;
import java.util.Scanner;
public class q9 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        str = str.toLowerCase(); 
	        boolean[] seen = new boolean[256];
	        String result = ""; 

	        for (char ch : str.toCharArray())
	        {
	            if (!seen[ch])
	            { 
	                seen[ch] = true; 
	                result += ch; 
	            }
	        }

	       System.out.println(result);
	    }
        

}
