package com.bschoolland.models;

/**
 * Represents a health product available in the arena store.
 * Health items extend {@link SalableProduct} and add a healAmount attribute
 * that indicates how many hit points the item restores when used.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class Health extends SalableProduct {

    /** The number of hit points this item restores. */
    private int healAmount;

    /**
     * Constructs a new Health item with the specified attributes.
     *
     * @param name        the name of the health item
     * @param description a brief description of the health item
     * @param price       the price in gold coins
     * @param quantity    the quantity available in inventory
     * @param healAmount  the number of hit points restored
     */
    public Health(String name, String description, double price, int quantity, int healAmount) {
        super(name, description, price, quantity);
        this.healAmount = healAmount;
    }

    /**
     * Returns the heal amount of this health item.
     *
     * @return the hit points restored
     */
    public int getHealAmount() {
        return healAmount;
    }

    /**
     * Sets the heal amount of this health item.
     *
     * @param healAmount the new hit points restored
     */
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    /**
     * Returns a formatted string representation of the health item,
     * including its heal amount attribute.
     *
     * @return a string describing the health item
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Heal: %d HP", healAmount);
    }
}
