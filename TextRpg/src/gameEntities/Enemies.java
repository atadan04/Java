package gameEntities;

public class Enemies extends Entity {


    public Enemies(double health, double armor, double damage) {
        super(health, armor, damage);
    }
    public static Enemies getRandomEnemy()
    {
        double armorRnd = Math.random()*50; //create random enemy
        double damageRnd = 5 + Math.random()*20;
        return new Enemies(100, armorRnd,damageRnd);
    }

}
