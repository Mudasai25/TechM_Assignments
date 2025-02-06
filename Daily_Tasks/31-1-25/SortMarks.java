package Sample;
import java.util.Scanner;
public class SortMarks {

	public static void main(String[] args) {

		
		        Scanner scanner = new Scanner(System.in);

		        // Input number of students
		        System.out.print("Enter number of students: ");
		        int n = scanner.nextInt();
		        scanner.nextLine(); // Consume newline

		        // Input number of subjects
		        System.out.print("Enter number of subjects: ");
		        int subjectsCount = scanner.nextInt();
		        scanner.nextLine(); // Consume newline

		        // Arrays to store student details
		        String[] names = new String[n];
		        int[][] marks = new int[n][subjectsCount];
		        int[] totals = new int[n];
		        double[] averages = new double[n];

		        // Input students' data
		        for (int i = 0; i < n; i++) {
		            System.out.print("\nEnter name of student " + (i + 1) + ": ");
		            names[i] = scanner.nextLine();

		            int sum = 0;
		            for (int j = 0; j < subjectsCount; j++) {
		                System.out.print("Enter marks for subject " + (j + 1) + ": ");
		                marks[i][j] = scanner.nextInt();
		                sum += marks[i][j];
		            }
		            scanner.nextLine(); // Consume newline

		            totals[i] = sum;
		            averages[i] = (double) sum / subjectsCount;
		        }

		        // Sorting students based on total marks in descending order
		        for (int i = 0; i < n - 1; i++) {
		            for (int j = i + 1; j < n; j++) {
		                if (totals[i] < totals[j]) {
		                    // Swap total marks
		                    int tempTotal = totals[i];
		                    totals[i] = totals[j];
		                    totals[j] = tempTotal;

		                    // Swap averages
		                    double tempAvg = averages[i];
		                    averages[i] = averages[j];
		                    averages[j] = tempAvg;

		                    // Swap names
		                    String tempName = names[i];
		                    names[i] = names[j];
		                    names[j] = tempName;

		                    // Swap marks
		                    int[] tempMarks = marks[i];
		                    marks[i] = marks[j];
		                    marks[j] = tempMarks;
		                }
		            }
		        }

		        // Display sorted students
		        System.out.println("\nSorted Students List Based on Total Marks:");
		        for (int i = 0; i < n; i++) {
		            System.out.println("Name: " + names[i] + ", Total Marks: " + totals[i] + ", Average: " + averages[i]);
		        }

		        scanner.close();
		    }

	}

