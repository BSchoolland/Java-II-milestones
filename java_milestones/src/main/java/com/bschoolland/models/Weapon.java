package com.bschoolland.models;

/**
 * Represents a weapon product available in the arena store.
 * Weapons extend {@link SalableProduct} and add a damage attribute
 * that indicates how much damage the weapon deals in combat.
 *
 * @author Benjamin Schoolland
 * @version 1.0
 */
public class Weapon extends SalableProduct {

    /** The amount of damage this weapon deals per hit. */
    private int damage;

    /**
     * Constructs a new Weapon with the specified attributes.
     *
     * @param name        the name of the weapon
     * @param description a brief description of the weapon
     * @param price       the price in gold coins
     * @param quantity    the quantity available in inventory
     * @param damage      the damage dealt per hit
     */
    public Weapon(String name, String description, double price, int quantity, int damage) {
        super(name, description, price, quantity);
        this.damage = damage;
    }

    /**
     * Returns the damage value of this weapon.
     *
     * @return the damage per hit
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage value of this weapon.
     *
     * @param damage the new damage per hit
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Returns a formatted string representation of the weapon,
     * including its damage attribute.
     *
     * @return a string describing the weapon
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Dmg: %d", damage);
    }
}
