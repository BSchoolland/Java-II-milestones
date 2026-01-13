package com.bschoolland;

import com.bschoolland.services.StoreFront;

/**
 * This class is the main class for the store front application.
 * It initializes the store front and starts the application.
 */
public class Main {
    /**
     * Main method to start the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        StoreFront store = new StoreFront();
        StartingActions startingActions = new StartingActions();
        startingActions.start(store);
    }   
}