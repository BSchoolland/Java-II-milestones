package com.bschoolland;

import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

/**
 * This class handles the starting actions for the store front application.
 * It provides a menu for the user to choose to use the app as a customer or store manager.
 * It also provides a method to handle the starting actions.
 */
public class StartingActions {
    
    /**
     * Method to start the application.
     * @param store The store front instance to access the store front functionality.
     */
    public void start(StoreFront store) {
      
        InputUtilities inputUtilities = new InputUtilities();

        System.out.println("Welcome to the StoreFront application!");
        System.out.println("Will you be using the app as a (1) customer or (2) store manager?");
        int result = inputUtilities.readInt("Enter 1 or 2: ", 1, 2);
        if (result == 1) {
            CustomerActions ca = new CustomerActions(store);
            ca.handleCustomerActions();  // Starts the application and user interaction flow
        } else {
            StoreManagerActions sma = new StoreManagerActions(store);
            sma.handleManagerActions();  // Starts the application and user interaction flow
        } 
    }
}