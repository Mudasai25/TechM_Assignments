package Sample;

import java.util.*;

class Inventory {
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    // Constructor
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    // Getters
    public String getInventoryId() {
        return inventoryId;
    }

    public int getThreshold() {
        return threshold;
    }
}

class So {
    public static Inventory[] replenish(Inventory[] inventories, int limit) {
        List<Inventory> result = new ArrayList<>();

        // Filter inventories based on threshold
        for (Inventory inv : inventories) {
            if (inv.getThreshold() >= limit) {
                result.add(inv);
            }
        }
        
        // Convert List to array and return
        return result.toArray(new Inventory[0]);
    }
}

public class Assign_Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Inventory[] inventories = new Inventory[4];

        // Reading 4 inventory objects
        for (int i = 0; i < 4; i++) {
            String inventoryId = sc.next();
            int maximumQuantity = sc.nextInt();
            int currentQuantity = sc.nextInt();
            int threshold = sc.nextInt();
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }

        // Read limit
        int limit = sc.nextInt();

        // Call replenish method
        Inventory[] filteredInventories = So.replenish(inventories, limit);

        // Print output
        for (Inventory inv : filteredInventories) {
            String status;
            int threshold = inv.getThreshold();

            if (threshold > 75) {
                status = "Critical Filling";
            } else if (threshold >= 50 && threshold <= 75) {
                status = "Moderate Filling";
            } else {
                status = "Non-Critical Filling";
            }

            System.out.println(inv.getInventoryId() + " " + status);
        }
        
        sc.close();
    }
}
