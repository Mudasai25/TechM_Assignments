package Sample;
import java.util.Scanner;
public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int spaces=0;
		int alpha=0;
		
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)==' ')
			{
				spaces+=1;
			}
			else if(Character.isLetter(s.charAt(i))) {
				alpha+=1;
			}
		}
		System.out.println("NO. of Spaces "+spaces+" and characters "+alpha);
		

	}

}
