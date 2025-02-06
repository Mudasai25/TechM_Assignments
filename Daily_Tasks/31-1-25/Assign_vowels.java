package Sample;
import java.util.Scanner;
public class Assign_vowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int flag=0;
		int vowell=0;
		int conso=0;
		String ss=sc.nextLine();
		for(int i=0;i<ss.length();i++)
		{
			char ch=ss.charAt(i);
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z'))
			{
			if (ch=='a' || ch=='A' || ch=='e'|| ch=='E'|| ch=='i'|| ch=='I'|| ch=='o'|| ch=='O'|| ch=='u'|| ch=='U')
			{
				vowell+=1;
				flag=1;
				
			}
			else {
				conso+=1;
			}
				
		    }
		}
		System.out.println("Vowels count is "+vowell+" Consonants count is "+conso);
			

	}

}
