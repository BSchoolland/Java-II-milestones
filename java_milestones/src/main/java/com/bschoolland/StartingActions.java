package com.bschoolland;

import com.bschoolland.services.StoreFront;
import com.bschoolland.util.InputUtilities;

/**
 * This class handles the starting actions for the store front application.
 * It displays a themed welcome with an ASCII art shopkeeper and provides
 * a menu for the user to choose to use the app as a customer or store manager.
 *
 * @author Benjamin Schoolland
 * @version 2.0
 */
public class StartingActions {

    /**
     * ASCII art shopkeeper displayed on application startup.
     */
    private static final String SHOPKEEPER_ART =
            "        _______________\n" +
            "       |  GAME  ITEM  |\n" +
            "       |    SHOP      |\n" +
            "       |_______________|\n" +
            "            |  |\n" +
            "         .-\"\"\"\"\"-.     \n" +
            "        /  o   o  \\   \n" +
            "       |     ^     |   \n" +
            "       |   \\___/   |   \n" +
            "        \\_________/    \n" +
            "       __|_________|__ \n" +
            "      /  |         |  \\\n" +
            "     /   |  SHOP   |   \\\n" +
            "    /    |  KEEP   |    \\\n" +
            "   |     |_________|     |\n" +
            "   |    /           \\    |\n" +
            "   |   /             \\   |\n" +
            "   |__/               \\__|";

    /**
     * Method to start the application.
     * Displays the ASCII art shopkeeper and themed welcome message,
     * then routes to either customer or manager actions.
     *
     * @param store The store front instance to access the store front functionality.
     */
    public void start(StoreFront store) {

        InputUtilities inputUtilities = new InputUtilities();

        System.out.println(SHOPKEEPER_ART);
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   Welcome to the Game Item Shop!");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("\"Ah, a visitor! Come in, come in!\"");
        System.out.println("\"I've got the finest weapons, sturdiest");
        System.out.println(" armor, and most potent potions in all");
        System.out.println(" the realm. Whether you're off to slay");
        System.out.println(" dragons or delve into dungeons, you've");
        System.out.println(" come to the right place!\"");
        System.out.println();
        System.out.println("Will you be using the app as a (1) customer or (2) store manager?");
        int result = inputUtilities.readInt("Enter 1 or 2: ", 1, 2);
        if (result == 1) {
            System.out.println();
            System.out.println("\"Welcome, adventurer! Let me show you what I've got...\"");
            CustomerActions ca = new CustomerActions(store);
            ca.handleCustomerActions();
        } else {
            System.out.println();
            System.out.println("\"Ah, the boss is here! Let me get the ledgers...\"");
            StoreManagerActions sma = new StoreManagerActions(store);
            sma.handleManagerActions();
        }
    }
}
