package com.bschoolland;

import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

public class StartingActions {

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