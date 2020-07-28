package gameEntities;

import Weapon.Weapons;

public abstract class Entity {
    private  double health = 100;
    private double armor = 0;
    private double damage = 5;
    private double healthWithArmour = health + armor;
    boolean isALive = true;

    public boolean getIsALive() {
        return isALive;
    }

    public void setALive(boolean ALive) {
        isALive = ALive;
    }

    public double getHealthWithArmour() {
        return healthWithArmour;
    }

    public void setHealthWithArmour(double healthWithArmour) {
        this.healthWithArmour = healthWithArmour;
    }

    public double getHealth() {
        return health;
    }

    public double getArmor() {
        return armor;
    }

    public double getDamage() {
        return damage;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }
    public void setHealth(double health){
        this.health = health;
    }
    public void setDamage(double damage){
        this.damage = damage;
    }
    public Entity(double health,double armor,double damage)
    {
        this.setHealth(health);
        this.setArmor(armor);
        this.setDamage(damage);
    }
    public Entity()
    {

    }
    public void selectWeapon(Weapons weapon)
    {
        this.damage+=weapon.getDamage();
    }

}
