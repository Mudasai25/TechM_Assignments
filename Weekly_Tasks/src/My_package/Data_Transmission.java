package My_assignments;
import java.util.*;
public class Data_Transmission {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		sc.close();
		str=str.substring(0,str.length()-1);
		
		String[] num = str.split(" ");
        List<Integer> p = new ArrayList<>();
        
        for (String i : num) {
            int value = Integer.parseInt(i);
            if (isPrime(value)) {
                p.add(value);
            }
        }
        
        if (p.size() < 2) {
            return;
        }
        
        Collections.sort(p);
        int total = p.size();
        int secondLargestPrime = p.get(p.size() - 2);
        
        System.out.println(total + secondLargestPrime);
	}
	public static boolean isPrime(int num) {
		if(num<2) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}
