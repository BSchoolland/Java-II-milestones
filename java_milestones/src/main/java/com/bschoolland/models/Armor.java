package com.bschoolland.models;

/**
 * Represents an armor product available in the arena store.
 * Armor extends {@link SalableProduct} and adds a defense attribute
 * that indicates how much damage the armor absorbs in combat.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class Armor extends SalableProduct {

    /** The amount of damage this armor absorbs per hit. */
    private int defense;

    /**
     * Constructs a new Armor with the specified attributes.
     *
     * @param name        the name of the armor
     * @param description a brief description of the armor
     * @param price       the price in gold coins
     * @param quantity    the quantity available in inventory
     * @param defense     the defense points provided
     */
    public Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    /**
     * Returns the defense value of this armor.
     *
     * @return the defense points
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense value of this armor.
     *
     * @param defense the new defense points
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Returns a formatted string representation of the armor,
     * including its defense attribute.
     *
     * @return a string describing the armor
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Def: %d", defense);
    }
}
