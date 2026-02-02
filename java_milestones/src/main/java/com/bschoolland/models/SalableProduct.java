package com.bschoolland.models;

/**
 * Base class representing a salable product in the arena store.
 * All products available for purchase in the store front extend this class.
 * Contains common attributes such as name, description, price, and quantity.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class SalableProduct {

    /** The name of the product. */
    private String name;

    /** A brief description of the product. */
    private String description;

    /** The price of the product in gold coins. */
    private double price;

    /** The quantity of this product available in inventory. */
    private int quantity;

    /**
     * Constructs a new SalableProduct with the specified attributes.
     *
     * @param name        the name of the product
     * @param description a brief description of the product
     * @param price       the price of the product in gold coins
     * @param quantity    the quantity available in inventory
     */
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the product.
     *
     * @return the product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the new product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the product.
     *
     * @return the product price in gold coins
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new product price in gold coins
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity available in inventory.
     *
     * @return the quantity in stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity available in inventory.
     *
     * @param quantity the new quantity in stock
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a formatted string representation of the product
     * suitable for display in the store front console.
     *
     * @return a string describing the product
     */
    @Override
    public String toString() {
        return String.format("%-25s | %-45s | %8.2f gold | Qty: %d",
                name, description, price, quantity);
    }
}
