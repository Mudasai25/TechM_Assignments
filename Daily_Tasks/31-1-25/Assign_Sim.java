package Sample;
import java.util.*;

class Sim {
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    // Constructor
    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    // Getters and Setters
    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    @Override
    public String toString() {
        return simId + " " + customerName + " " + circle + " " + ratePerSecond;
    }
}

class Solution {
    // Static method to transfer circle
    public static Sim[] transferCircle(Sim[] sims, String circle1, String circle2) {
        List<Sim> result = new ArrayList<>();
        
        // Filter and change circle to circle2
        for (Sim sim : sims) {
            if (sim.getCircle().equals(circle1)) {
                sim.setCircle(circle2);
                result.add(sim);
            }
        }
        
        // Sort by ratePerSecond in descending order
        result.sort((s1, s2) -> Double.compare(s2.getRatePerSecond(), s1.getRatePerSecond()));
        
        // Convert list to array and return
        return result.toArray(new Sim[0]);
    }
}

public class Assign_Sim {
    public static void main(String[] args) {
        // Reading the input values for the Sim objects
        Scanner sc = new Scanner(System.in);
        
        Sim[] sims = new Sim[5];
        
        // Reading data for 5 Sim objects
        for (int i = 0; i < 5; i++) {
            int simId = sc.nextInt();
            String customerName = sc.next();
            double balance = sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            String circle = sc.next();
            sims[i] = new Sim(simId, customerName, balance, ratePerSecond, circle);
        }
        
        // Reading the circles
        String circle1 = sc.next();
        String circle2 = sc.next();
        
        // Calling the transferCircle method
        Sim[] result = Solution.transferCircle(sims, circle1, circle2);
        
        // Printing the result
        for (Sim sim : result) {
            System.out.println(sim);
        }
    }
}
