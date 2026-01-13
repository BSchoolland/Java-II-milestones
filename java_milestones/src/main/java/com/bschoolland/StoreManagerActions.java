package com.bschoolland;
import com.bschoolland.util.InputUtilities;
import com.bschoolland.services.StoreFront;

public class StoreManagerActions {
    private StoreFront store;
    private InputUtilities inputUtilities;

    public StoreManagerActions(StoreFront store) {
        this.inputUtilities = new InputUtilities();
        this.store = store;
    }
    public void handleManagerActions() {
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("You are using the app as a store manager.");
            System.out.println("What would you like to do?");
            System.out.println("1. View Products");
            System.out.println("2. Search For a Product by Name or Description");
            System.out.println("3. Add Product to Inventory");
            System.out.println("4. Remove Product from Inventory");
            System.out.println("5. Update Product in Inventory");
            System.out.println("6. Save Inventory to File");
            System.out.println("7. Load Inventory from File");
            System.out.println("0. Exit");
            int choice = inputUtilities.readInt("Enter your choice: ", 0, 7);
            switch (choice) {
                case 1:
                    System.out.println("You choose to view products");
                    break;
                case 2:
                    System.out.println("You choose to search for a product by name or description");
                    break;
                case 3:
                    System.out.println("You choose to add a product to inventory");
                    break;
                case 4:
                    System.out.println("You choose to remove a product from inventory");
                    break;
                case 5:
                    System.out.println("You choose to update a product in inventory");
                    break;
                case 6:
                    System.out.println("You choose to save inventory to file");
                    break;
                case 7:
                    System.out.println("You choose to load inventory from file");
                    break;
                case 0:
                    System.out.println("You choose to exit");
                    exitRequested = true;
                    break;
            }
            if (!exitRequested) {
                System.out.println("This is Milestone #1 No actual functionality has been implemented yet.");
                System.out.println("Press Enter to continue...");
                inputUtilities.waitForEnter();
            }
        }
        System.out.println("Goodbye!");
    }
}
