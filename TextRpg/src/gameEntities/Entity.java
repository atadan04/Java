package gameEntities;

public abstract class Entity {
    private double health;
    private double armor;
    private double damage;

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
}
