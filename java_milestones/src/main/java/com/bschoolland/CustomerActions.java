package com.bschoolland;
import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

/**
 * This class handles the customer actions for the store front application.
 * It provides a menu for the customer to view products, search for products, add products to cart, remove products from cart, view cart, and checkout.
 * It also provides a method to handle the customer actions.
 */
public class CustomerActions {
    // store front instance to access the store front functionality
    private StoreFront store;
    // input utilities instance to handle the user input
    private InputUtilities inputUtilities;

    /**
     * Constructor for the CustomerActions class.
     * @param store The store front instance to access the store front functionality.
     */
    public CustomerActions(StoreFront store) {
        this.store = store;
        this.inputUtilities = new InputUtilities();
    }
    /**
     * Method to handle the customer actions.
     * It provides a menu for the customer to view products, search for products, add products to cart, remove products from cart, view cart, and checkout.
     * It also provides a method to handle the customer actions.
     */
    public void handleCustomerActions() {
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("You are using the app as a customer.");
            System.out.println("1. View Products");
            System.out.println("2. Search For a Product by Name or Description");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            int choice = inputUtilities.readInt("Enter your choice: ", 0, 6);
            switch (choice) {
                case 1:
                    System.out.println("You choose to view products");
                    break;
                case 2:
                    System.out.println("You choose to search for a product by name or description");
                    break;
                case 3:
                    System.out.println("You choose to add a product to cart");
                    break;
                case 4:
                    System.out.println("You choose to remove a product from cart");
                    break;
                case 5:
                    System.out.println("You choose to view cart");
                    break;
                case 6:
                    System.out.println("You choose to checkout");
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
    