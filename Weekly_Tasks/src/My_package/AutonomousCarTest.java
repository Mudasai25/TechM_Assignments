package My_assignments;
import java.util.*;
class AutonomousCar{
	int carId;
	String brand;
	int noOfTestsConducted;
	int noOfTestsPassed;
	String environment;
	String grade;
	public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
		this.carId = carId;
		this.brand = brand;
		this.noOfTestsConducted = noOfTestsConducted;
		this.noOfTestsPassed = noOfTestsPassed;
		this.environment = environment;
	}
	public String getBrand() {
		return brand;
	}
	public int getNoOfTestsConducted() {
		return noOfTestsConducted;
	}
	public int getNoOfTestsPassed() {
		return noOfTestsPassed;
	}
	public String getEnvironment() {
		return environment;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}	
}
public class AutonomousCarTest {
	public static int findTestPassedByEnv(AutonomousCar[] obj, String env) {
		int sum=0;
		for(AutonomousCar i: obj) {
			if(i.getEnvironment().equals(env)) {
				sum+=i.getNoOfTestsPassed();
			}
		}
		return sum;
	}
	public static AutonomousCar updateCarGrade(AutonomousCar[] cars, String Searchbrand) {
		int rating=0;
		for(AutonomousCar i: cars) {
			if(i.getBrand().equalsIgnoreCase(Searchbrand)) {
				rating =(i.getNoOfTestsPassed() * 100)/i.getNoOfTestsConducted();
				i.setGrade((rating>=80)? "A1":"B2");
				return i;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner Sc=new Scanner(System.in);
        
        AutonomousCar[] obj= new AutonomousCar[4];
        for(int i=0;i<4;i++) {
        	int carId=Sc.nextInt();
        	Sc.nextLine();
        	String brand=Sc.nextLine();
        	int noOfTestsConducted=Sc.nextInt();
        	int noOfTestsPassed=Sc.nextInt();
        	Sc.nextLine();
        	String environment=Sc.nextLine();
        	obj[i]=new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }
        
        String SrcEnvironment=Sc.nextLine();
        String Srcbrand=Sc.nextLine();
        //AutonomousCarTest ACT=new AutonomousCarTest();
        
        int total= AutonomousCarTest.findTestPassedByEnv(obj,SrcEnvironment);
        
        if (total > 0) {
            System.out.println(total);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }

        AutonomousCar resultCar = AutonomousCarTest.updateCarGrade(obj, Srcbrand);
        if (resultCar != null) {
            System.out.println(resultCar.getBrand() + "::" + resultCar.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }
        Sc.close();
	}

}
