package com.bschoolland;

import com.bschoolland.models.SalableProduct;
import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

/**
 * Handles the customer-facing actions for the Game Item Shop application.
 * Provides a console menu allowing the customer to view products,
 * purchase items, and return (cancel) previously purchased items.
 * Interacts with the {@link StoreFront} to manage inventory operations.
 * Features thematic shopkeeper dialogue for an immersive experience.
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
     * Displays a themed menu of available commands and processes the customer's
     * choice until they choose to exit. Provides shopkeeper feedback for each action.
     */
    public void handleCustomerActions() {
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println("        Game Item Shop - Customer Menu");
            System.out.println("==========================================");
            System.out.println("  1. Browse Wares      (View Products)");
            System.out.println("  2. Buy an Item       (Purchase)");
            System.out.println("  3. Return an Item    (Refund)");
            System.out.println("  0. Leave the Shop    (Exit)");
            System.out.println("==========================================");
            int choice = inputUtilities.readInt("What would you like to do? ", 0, 3);
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
        System.out.println();
        System.out.println("\"Safe travels, adventurer! Come back");
        System.out.println(" anytime you need supplies!\"");
        System.out.println();
        System.out.println("You leave the Game Item Shop.");
    }

    /**
     * Displays all available products in the store inventory
     * with thematic shopkeeper dialogue.
     */
    private void viewProducts() {
        System.out.println();
        System.out.println("\"Take a look at my finest goods!\"");
        store.displayProducts();
    }

    /**
     * Guides the customer through purchasing a product.
     * Displays the inventory, prompts for a product selection,
     * and provides shopkeeper feedback on whether the purchase
     * succeeded or failed (e.g., if the item is out of stock).
     */
    private void purchaseProduct() {
        System.out.println();
        System.out.println("\"What catches your eye, adventurer?\"");
        store.displayProducts();
        int size = store.getInventorySize();
        if (size == 0) {
            System.out.println("\"Sorry, I'm all out of stock! Check back later.\"");
            return;
        }
        System.out.println("Enter 0 to cancel.");
        int choice = inputUtilities.readInt("Enter the item number to purchase: ", 0, size);
        if (choice == 0) {
            System.out.println("\"Changed your mind? No worries, take your time!\"");
            return;
        }
        int index = choice - 1;
        SalableProduct product = store.getProduct(index);
        if (store.purchaseProduct(index)) {
            System.out.println();
            System.out.println("\"Excellent choice! The " + product.getName() + " is yours!\"");
            System.out.println("  Purchased for " + String.format("%.2f", product.getPrice()) + " gold.");
            System.out.println("  Remaining in stock: " + product.getQuantity());
        } else {
            System.out.println();
            System.out.println("\"Ah, sorry adventurer... I'm fresh out of " + product.getName() + "!\"");
            System.out.println("\"Check back later, I might get more in stock.\"");
        }
    }

    /**
     * Guides the customer through returning (cancelling) a previously
     * purchased product. Displays the inventory, prompts for a product
     * selection, and increases the inventory quantity by one.
     * Includes thematic shopkeeper dialogue.
     */
    private void returnProduct() {
        System.out.println();
        System.out.println("\"Need to return something? No problem!\"");
        store.displayProducts();
        int size = store.getInventorySize();
        if (size == 0) {
            System.out.println("\"I don't have any items on record...\"");
            return;
        }
        System.out.println("Enter 0 to cancel.");
        int choice = inputUtilities.readInt("Enter the item number to return: ", 0, size);
        if (choice == 0) {
            System.out.println("\"Keeping it after all? Good choice!\"");
            return;
        }
        int index = choice - 1;
        SalableProduct product = store.getProduct(index);
        if (store.returnProduct(index)) {
            System.out.println();
            System.out.println("\"Got it! One " + product.getName() + " returned to the shelf.\"");
            System.out.println("  Updated stock: " + product.getQuantity());
        } else {
            System.out.println("\"Hmm, something went wrong with that return...\"");
        }
    }
}
