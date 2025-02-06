package My_package;
import java.util.*;

public class Task2 {
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		
		System.out.println("Enter no of students: ");
		int n=Sc.nextInt();
		
		String[] names=new String[n];
		int[][]	marks=new int[n][5];
		int[] sum=new int[n];
		double[] avg = new double[n];
		
		for(int i=0;i<n;i++) {
			Sc.nextLine();
			System.out.println("Enter student name: ");
			names[i]=Sc.nextLine();
			
			System.out.println("Enter marks for 5 subjects:");
            int total = 0;
            for (int j = 0; j < 5; j++) {
                marks[i][j] = Sc.nextInt();
                total += marks[i][j];
            }
            sum[i] = total;
            avg[i] = total / 5.0;
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(avg[i]<avg[j]) {
					String temp1=names[i];
					names[i]=names[j];
					names[j]=temp1;
					
					int temp2=sum[i];
					sum[i]=sum[j];
					sum[j]=temp2;
					
					double temp3=avg[i];
					avg[i]=avg[j];
					avg[j]=temp3;
				}
			}
		}
		for (int i = 0; i < n; i++) {
            System.out.println("Name: " + names[i] + ", Total Marks: " + sum[i] + ", Average: " + String.format("%.2f", avg[i]));
        }
		Sc.close();
		
	}
}
