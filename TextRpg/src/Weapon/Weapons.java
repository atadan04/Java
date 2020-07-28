package Weapon;

import Inventory.Item;

public abstract class Weapons implements Item {
    private double damage = 10;
    private String name;
    private double weaponRange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double value)
    {
        this.damage = value;
    }


    public double getDamage() {
        return damage;
    }

    public double getWeaponRange() {
        return weaponRange;
    }

    public void setWeaponRange(double weaponRange) {
        this.weaponRange = weaponRange;
    }
}
