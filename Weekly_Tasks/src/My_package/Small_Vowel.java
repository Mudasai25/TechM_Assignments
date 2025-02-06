package My_assignments;
import java.util.Scanner;
public class Small_Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Sc=new Scanner(System.in);
		String input = Sc.nextLine().toLowerCase(); 
        char small = 'z'; 
        
        for (char ch : input.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch < small) {
                    small = ch;
                }
            }
        }
        System.out.println(small);
        Sc.close();
	}

}
