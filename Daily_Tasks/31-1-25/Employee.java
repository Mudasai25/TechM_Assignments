package Sample;

public class Employee {
	    private int empId;
	    private String empName;
	    private double sal;
	    private int yearsWorked;

	    // Constructor
	    public Employee(int empId, String empName, double sal, int yearsWorked) {
	        this.empId = empId;
	        this.empName = empName;
	        this.sal = sal;
	        this.yearsWorked = yearsWorked;
	    }

	    // Method to set employee details
	    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
	        this.empId = empId;
	        this.empName = empName;
	        this.sal = sal;
	        this.yearsWorked = yearsWorked;
	    }

	    // Method to get employee details
	    public void getEmployeeDetails() {
	        System.out.println("Employee ID: " + empId);
	        System.out.println("Employee Name: " + empName);
	        System.out.println("Annual Salary: " + sal);
	        System.out.println("Years Worked: " + yearsWorked);
	    }

	    // Method to check loan eligibility
	    public void getLoanEligibility() {
	        if (yearsWorked > 5) {
	            if (sal >= 15_00_000) {
	                System.out.println("Eligible for loan: 7 lakhs");
	            } else if (sal >= 10_00_000) {
	                System.out.println("Eligible for loan: 5 lakhs");
	            } else if (sal >= 6_00_000) {
	                System.out.println("Eligible for loan: 2 lakhs");
	            } else {
	                System.out.println("Not eligible for loan");
	            }
	        } else {
	            System.out.println("Not eligible for loan");
	        }
	    }

	    // Main method for testing
	    public static void main(String[] args) {
	        Employee emp1 = new Employee(101, "John Doe", 12_00_000, 6);
	        emp1.getEmployeeDetails();
	        emp1.getLoanEligibility();
	    }
	}
