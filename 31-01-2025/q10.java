package intro;
import java.util.Scanner;

public class q10 {
	 public static void main(String args[])
	 {
		 Scanner sc=new Scanner(System.in);
		 String s=sc.nextLine();
		 int x=0,y=0;
		 for(int i=0;i<s.length();i++)
		 {
			 if(Character.isLetter(s.charAt(i)))
			 {
				 x=x+1;
			 }
			 if(s.charAt(i)==' ')
			 {
				 y=y+1;
			 }
		 }
		 System.out.println("Characters are " +x);
		 System.out.println("Spaces are "+y);
	 }

}
