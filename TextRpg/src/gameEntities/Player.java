package gameEntities;

import Inventory.Backpack;
import Weapon.Weapons;

public class Player extends Entity {
private String name;
private Weapons weapon = null;
private Backpack backpack = new Backpack();

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Player()
{

}

    public Player(double health, double armor, double damage, String name) {
        super(health, armor, damage);
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
public void choseWeapon(Weapons weapon)
{
    this.weapon = weapon;
    setDamage(this.getDamage() + weapon.getDamage());
}
}
