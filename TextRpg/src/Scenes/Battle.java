package Scenes;

import gameEntities.Enemies;
import gameEntities.Player;

public class Battle {
    public  static void battle(Enemies enemy, Player player)
    {
        boolean canFight = true;

        while(canFight) {
            if (player.getIsALive()&&enemy.getIsALive())
            {
                canFight = true;
            }
            else
            {
                canFight = false;
            }

            if (player.getHealthWithArmour() <= 0) {
                player.setALive(false);
            } else if (enemy.getHealthWithArmour() <= 0) {
                enemy.setALive(false);
            }
            enemy.setHealthWithArmour(enemy.getHealthWithArmour() - player.getDamage()); //Player attack

            player.setHealthWithArmour(player.getHealthWithArmour() - enemy.getDamage()); //Enemie attack


        }

        if (player.getIsALive())
        {
            if (player.getHealthWithArmour()>=100)
            {
                player.setHealth(100);
                player.setArmor(player.getHealthWithArmour()-100);
            }
            else if(player.getHealthWithArmour()<100)
            {
                player.setHealth(player.getHealthWithArmour());
                player.setArmor(0);
            }
            System.out.println("You Win!");
        }
        if (enemy.getIsALive())
        {
            if (enemy.getHealthWithArmour()>=100)
            {
                enemy.setHealth(100);
                enemy.setArmor(enemy.getHealthWithArmour()-100);
            }
            else if(enemy.getHealthWithArmour()<100)
            {
                enemy.setHealth(enemy.getHealthWithArmour());
                enemy.setArmor(0);
            }
        }
        if (!player.getIsALive())
        {

            player.setHealth(0);
            player.setArmor(0);
            System.out.println("You Dead!");
            System.out.println("Your opponent has left " + "Health: " +enemy.getHealth() + " Armour: " + enemy.getArmor());
        }

    }
}
