package My_package;
import java.util.*;
public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		
		StringBuilder s=new StringBuilder();
	        
	    for (int i = 0; i < str.length(); i++) {
	        if (i % 2 == 0) {
	                s.append(Character.toUpperCase(str.charAt(i)));
            } else {
	                s.append(Character.toLowerCase(str.charAt(i)));
	            }
      }	
	    System.out.println(s.toString());
   sc.close();
	}

}
