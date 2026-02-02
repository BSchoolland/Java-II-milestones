package com.bschoolland.services;

import com.bschoolland.models.SalableProduct;
import com.bschoolland.models.Weapon;
import com.bschoolland.models.Armor;
import com.bschoolland.models.Health;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the store front inventory for the Game Item Shop.
 * Provides functionality to initialize inventory, view products,
 * purchase products, and return (cancel) purchases.
 * The store is populated with hard-coded initial inventory
 * consisting of weapons, armor, and health items.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class StoreFront {

    /** The list of salable products available in the store inventory. */
    private List<SalableProduct> inventory;

    /**
     * Constructs a new StoreFront and populates it with the initial
     * hard-coded inventory of arena products.
     */
    public StoreFront() {
        inventory = new ArrayList<>();
        initializeInventory();
    }

    /**
     * Populates the store inventory with the initial set of products.
     * Includes 2 weapons, 2 armor pieces, and 2 health items.
     */
    private void initializeInventory() {
        // Weapons
        inventory.add(new Weapon("Flame Sword",
                "A blazing sword forged in dragon fire",
                150.00, 5, 35));
        inventory.add(new Weapon("Shadow Dagger",
                "A swift dagger that strikes from the darkness",
                85.00, 8, 20));

        // Armor
        inventory.add(new Armor("Iron Shield",
                "A sturdy shield made of tempered iron",
                120.00, 4, 30));
        inventory.add(new Armor("Dragon Scale Chestplate",
                "Legendary armor crafted from dragon scales",
                250.00, 3, 50));

        // Health
        inventory.add(new Health("Healing Potion",
                "A crimson potion that restores vitality",
                25.00, 15, 50));
        inventory.add(new Health("Elixir of Life",
                "A rare elixir that fully restores health",
                75.00, 5, 100));
    }

    /**
     * Returns the list of all products currently in the store inventory.
     *
     * @return the list of salable products
     */
    public List<SalableProduct> getInventory() {
        return inventory;
    }

    /**
     * Displays all products in the store inventory to the console,
     * numbered for easy selection.
     */
    public void displayProducts() {
        System.out.println("\n===== Game Item Shop - Inventory =====");
        System.out.printf("%-4s %-25s | %-45s | %13s | %s%n",
                "#", "Name", "Description", "Price", "Details");
        System.out.println("-".repeat(120));
        for (int i = 0; i < inventory.size(); i++) {
            System.out.printf("%-4d %s%n", (i + 1), inventory.get(i).toString());
        }
        System.out.println("=".repeat(120));
    }

    /**
     * Attempts to purchase a product by reducing its inventory quantity by one.
     * Returns true if the purchase was successful, false if the product is
     * out of stock.
     *
     * @param index the zero-based index of the product in the inventory list
     * @return {@code true} if the purchase succeeded, {@code false} if out of stock
     */
    public boolean purchaseProduct(int index) {
        if (index < 0 || index >= inventory.size()) {
            return false;
        }
        SalableProduct product = inventory.get(index);
        if (product.getQuantity() <= 0) {
            return false;
        }
        product.setQuantity(product.getQuantity() - 1);
        return true;
    }

    /**
     * Cancels a purchase (returns a product) by increasing its inventory
     * quantity by one.
     *
     * @param index the zero-based index of the product in the inventory list
     * @return {@code true} if the return succeeded, {@code false} if the index is invalid
     */
    public boolean returnProduct(int index) {
        if (index < 0 || index >= inventory.size()) {
            return false;
        }
        SalableProduct product = inventory.get(index);
        product.setQuantity(product.getQuantity() + 1);
        return true;
    }

    /**
     * Returns the number of products in the store inventory.
     *
     * @return the inventory size
     */
    public int getInventorySize() {
        return inventory.size();
    }

    /**
     * Returns the product at the specified index.
     *
     * @param index the zero-based index of the product
     * @return the {@link SalableProduct} at the given index, or {@code null} if invalid
     */
    public SalableProduct getProduct(int index) {
        if (index < 0 || index >= inventory.size()) {
            return null;
        }
        return inventory.get(index);
    }
}
