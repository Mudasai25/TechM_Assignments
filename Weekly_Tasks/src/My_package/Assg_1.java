package My_assignments;
import java.util.Scanner;

class Assignments{
	int id;
    String name;
    String technology;
    int experienceInYears;
    
    public Assignments(int id, String name, String technology, int experienceInYears){
    	this.id=id;
    	this.name=name;
    	this.technology=technology;
    	this.experienceInYears=experienceInYears;
    }
    public int getId() {
    	return id;
    }
    public String getTechnology() {
    	return technology;
    }
    public int getExperience() {
    	return experienceInYears;
    }
    
}
public class Assg_1 {
	public void associatesForGivenTechnology(Assignments[] assign, String searchName) {
		for(Assignments i: assign) {
			if(i.getTechnology().equalsIgnoreCase(searchName) && i.getExperience()%5==0) {
				System.out.println(i.getId());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
        Assignments[] assign = new Assignments[5];
        
        for(int i=0;i<5;i++) {
        	int id=sc.nextInt();
        	sc.nextLine();
        	String name=sc.nextLine();
        	String technology=sc.nextLine();
        	int experienceInYears=sc.nextInt();
        	sc.nextLine();
        	assign[i]=new Assignments(id, name, technology, experienceInYears);
        }
        String searchName=sc.nextLine();
        
        Assg_1 obj=new Assg_1();
        obj.associatesForGivenTechnology(assign,searchName);
        sc.close();
	}

}
