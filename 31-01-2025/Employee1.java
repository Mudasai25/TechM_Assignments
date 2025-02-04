package intro;

import java.util.Scanner;

public class Employee1 {
	static double sal;
	static int empexp;
	static String empname;
	public void setEmployeeDetails()
	{
	
		Scanner sca=new Scanner(System.in);
		System.out.println("enter employee namme");
		empname=sca.nextLine();
		System.out.println("enter employee experience");
		empexp=sca.nextInt();
		System.out.println("enter employee salary");
		sal=sca.nextDouble();
		
		}
	public void getEmployeeDetails()
	{
		System.out.println("employee name is"+empname);
	}
	public void getLoanEligibility()
	{
		  if(empexp>5)
		  {
			  if(sal >= 600000 && sal<1000000 )
			  {
				  System.out.println("2,00,000/- Loan is granted");
			  }
			  if(sal>=1000000 && sal<1500000)
			  {
				  System.out.println("5,00,000/- Loan is granted");
			  }
			  if(sal>=1500000)
			  {
				  System.out.println("7,00,000/- Loan is granted");
			  }
		  }
		  else
		  {
			  System.out.println("Not Eligibile For Loan");
		  }
	}
		
		
	public static void main(String args[])
	{
		Employee1 e=new Employee1();
		e.setEmployeeDetails();
		e.getEmployeeDetails();
		e.getLoanEligibility();
	}
}
		
		
		
		
	

