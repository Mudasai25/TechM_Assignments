package My_package;

public class Employee {
    int empId;
    String empName;
    double sal;
    public Employee(int empId, String empName, double sal) {
    	this.empId=empId;
    	this.empName=empName;
    	this.sal=sal;
    }
    public void getEmployeeDetails() {
    	System.out.println("Employee Id: "+empId+" name : "+empName+" Salary : "+sal);
    }
    public void setEmployeeDetails(int empId, String empName, double sal) {
    	this.empId=empId;
    	this.empName=empName;
    	this.sal=sal;
    }
    
    public void getLoanEligibility(int Exp) {
    	if(Exp>5) {
    		if(sal>=1500000) {
    			System.out.println("2 lakhs of loan is granted.");
    		}else if(sal>=1000000) {
    			System.out.println("5 lakhs of loan is granted.");
    		}else if(sal>600000){
    			System.out.println("7 lakhs of loan is granted.");
    		}
    		else {
    			System.out.println("No loan Sactioned");
    		}
    	}else {
			System.out.println("No loan Sactioned");
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee(1001,"ramanagaadu",800000);
		emp.getEmployeeDetails();
		emp.getLoanEligibility(8);
		emp.setEmployeeDetails(101, "charan", 1000000);
        emp.getLoanEligibility(6);
	}

}
