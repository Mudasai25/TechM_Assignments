package intro;

import java.util.Scanner;

import java.lang.System;
import java.util.Arrays;
import java.util.Comparator;

public class task4 {
	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Students : ");
		int n = sc.nextInt();
		int marks[][] = new int[n][3];
		String[] names = new String[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the name of the student : " + (i+1) + " : ");
			names[i] = sc.next();
			for(int j=0;j<3;j++)
			{
				System.out.print("Enter student - " + (i+1) + " subject - " + (j+1)+" marks : ");
				marks[i][j] = sc.nextInt();
			}
		}
		int[][] std_report = new int[n][6];
		createReport(std_report,n,marks);
		System.out.println("Student Report");
		for(int i=0;i<n;i++)
		{
			System.out.print(names[i] + " ");
			for(int j=1;j<6;j++)
			{
				System.out.print(std_report[i][j] + " ");
			}
			System.out.println();
		}
		Arrays.sort(std_report,Comparator.comparingInt(o->o[5]));
		System.out.println("Class Report : ");
		for(int i=n-1;i>=0;i--)
		{
			System.out.print(names[std_report[i][0]] + " ");
			for(int j=1;j<6;j++)
			{
				System.out.print(std_report[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void createReport(int[][] std_report,int n,int[][] marks)
	{
		for(int i=0;i<n;i++)
		{
			std_report[i][0] = i;
			std_report[i][1] = marks[i][0];
			std_report[i][2] = marks[i][1];
			std_report[i][3] = marks[i][2];
			std_report[i][4] = marks[i][0] + marks[i][1] + marks[i][2];
			std_report[i][5] = std_report[i][4]/3;
		}

		
		
	}

}
