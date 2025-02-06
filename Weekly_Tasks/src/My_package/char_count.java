package My_assignments;

import java.util.Scanner;

public class char_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine().toLowerCase();
		
		int s=0,c=0;
		for(char ch: str.toCharArray()) {
			if (Character.isLetter(ch)) {
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				s++;
			}else{
				c++;}
			}
		}
		System.out.println("No of Vowels count : "+s+" No of consonants : "+c);
		sc.close();
	}

}
