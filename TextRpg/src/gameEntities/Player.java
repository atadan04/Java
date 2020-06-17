package gameEntities;

public class Player extends Entity {
private String name;



    public Player(double health, double armor, double damage, String name) {
        super(health, armor, damage);
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

}
