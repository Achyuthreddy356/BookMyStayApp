/**
 * UseCase3InventorySetup.java
 *
 * This class demonstrates Use Case 3 of the Hotel Booking Management System.
 * It introduces centralized inventory management using a HashMap to store
 * and manage room availability consistently across the system.
 *
 * @author YourName
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

// Inventory class encapsulating availability logic
class RoomInventory {
    private Map<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability for a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        } else {
            System.out.println("Room type not found in inventory: " + roomType);
        }
    }

    // Method to display current inventory state
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> Available: " + entry.getValue());
        }
    }
}

// Application entry point
public class UseCase3InventorySetup {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" Welcome to the Hotel Booking System ");
        System.out.println(" Version: 3.1 ");
        System.out.println("=======================================");

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Simulate an update (e.g., one Single Room booked)
        System.out.println("\nUpdating inventory after booking...");
        inventory.updateAvailability("Single Room", inventory.getAvailability("Single Room") - 1);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication terminated successfully!");
    }
}