package com.bschoolland;

import com.bschoolland.models.SalableProduct;
import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

/**
 * Handles the customer-facing actions for the store front application.
 * Provides a console menu allowing the customer to view products,
 * purchase items, and return (cancel) previously purchased items.
 * Interacts with the {@link StoreFront} to manage inventory operations.
 *
 * @author Benjamin Schoolland
 * @version 2.0
 */
public class CustomerActions {

    /** The store front instance providing inventory access. */
    private StoreFront store;

    /** The input utilities instance for reading user input. */
    private InputUtilities inputUtilities;

    /**
     * Constructs a new CustomerActions with a reference to the store front.
     *
     * @param store the {@link StoreFront} instance to access inventory
     */
    public CustomerActions(StoreFront store) {
        this.store = store;
        this.inputUtilities = new InputUtilities();
    }

    /**
     * Runs the main customer interaction loop.
     * Displays a menu of available commands and processes the customer's
     * choice until they choose to exit. Provides feedback for each action.
     */
    public void handleCustomerActions() {
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Purchase a Product");
            System.out.println("3. Return a Product");
            System.out.println("0. Exit");
            int choice = inputUtilities.readInt("Enter your choice: ", 0, 3);
            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    purchaseProduct();
                    break;
                case 3:
                    returnProduct();
                    break;
                case 0:
                    exitRequested = true;
                    break;
            }
        }
        System.out.println("Thank you for visiting the Arena Store. Goodbye!");
    }

    /**
     * Displays all available products in the store inventory.
     */
    private void viewProducts() {
        store.displayProducts();
    }

    /**
     * Guides the customer through purchasing a product.
     * Displays the inventory, prompts for a product selection,
     * and provides feedback on whether the purchase succeeded or failed
     * (e.g., if the item is out of stock).
     */
    private void purchaseProduct() {
        store.displayProducts();
        int size = store.getInventorySize();
        if (size == 0) {
            System.out.println("No products available for purchase.");
            return;
        }
        System.out.println("Enter 0 to cancel.");
        int choice = inputUtilities.readInt("Enter the product number to purchase: ", 0, size);
        if (choice == 0) {
            System.out.println("Purchase cancelled.");
            return;
        }
        int index = choice - 1;
        SalableProduct product = store.getProduct(index);
        if (store.purchaseProduct(index)) {
            System.out.println("Successfully purchased: " + product.getName()
                    + " for " + String.format("%.2f", product.getPrice()) + " gold.");
            System.out.println("Remaining in stock: " + product.getQuantity());
        } else {
            System.out.println("Sorry, " + product.getName() + " is out of stock!");
        }
    }

    /**
     * Guides the customer through returning (cancelling) a previously
     * purchased product. Displays the inventory, prompts for a product
     * selection, and increases the inventory quantity by one.
     */
    private void returnProduct() {
        store.displayProducts();
        int size = store.getInventorySize();
        if (size == 0) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Enter 0 to cancel.");
        int choice = inputUtilities.readInt("Enter the product number to return: ", 0, size);
        if (choice == 0) {
            System.out.println("Return cancelled.");
            return;
        }
        int index = choice - 1;
        SalableProduct product = store.getProduct(index);
        if (store.returnProduct(index)) {
            System.out.println("Successfully returned: " + product.getName());
            System.out.println("Updated stock: " + product.getQuantity());
        } else {
            System.out.println("Error: Could not process return.");
        }
    }
}
