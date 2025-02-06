package Sample;

import java.util.Scanner;
import java.util.Arrays;
public class Assign_Uniq {
    public static void main(String[] args) {
        String res = ""; // Initialize as empty string
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String ss = sc.nextLine();
        char[] ch = ss.toCharArray();
        Arrays.sort(ch);
        String sor = new String(ch);
        for (int i = 0; i < sor.length() - 1; i++) {
            if (sor.charAt(i) != sor.charAt(i + 1)) {
                res += sor.charAt(i);
            }
        }

        System.out.println("Consecutive duplicates: " + res);
    }
}

