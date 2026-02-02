package com.bschoolland;

import com.bschoolland.util.InputUtilities;
import com.bschoolland.services.StoreFront;

/**
 * Handles the store manager actions for the store front application.
 * Provides a console menu with options for managing inventory.
 * Currently serves as a placeholder for future milestone implementations.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class StoreManagerActions {

    /** The store front instance providing inventory access. */
    private StoreFront store;

    /** The input utilities instance for reading user input. */
    private InputUtilities inputUtilities;

    /**
     * Constructs a new StoreManagerActions with a reference to the store front.
     *
     * @param store the {@link StoreFront} instance to access inventory
     */
    public StoreManagerActions(StoreFront store) {
        this.inputUtilities = new InputUtilities();
        this.store = store;
    }

    /**
     * Runs the main store manager interaction loop.
     * Displays a menu of available management commands and processes
     * the manager's choice until they choose to exit.
     * Note: Full functionality will be implemented in a future milestone.
     */
    public void handleManagerActions() {
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("\n--- Store Manager Menu ---");
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
                    store.displayProducts();
                    break;
                case 2:
                    System.out.println("Search functionality coming in a future milestone.");
                    break;
                case 3:
                    System.out.println("Add product functionality coming in a future milestone.");
                    break;
                case 4:
                    System.out.println("Remove product functionality coming in a future milestone.");
                    break;
                case 5:
                    System.out.println("Update product functionality coming in a future milestone.");
                    break;
                case 6:
                    System.out.println("Save inventory functionality coming in a future milestone.");
                    break;
                case 7:
                    System.out.println("Load inventory functionality coming in a future milestone.");
                    break;
                case 0:
                    exitRequested = true;
                    break;
            }
        }
        System.out.println("Goodbye, Manager!");
    }
}
