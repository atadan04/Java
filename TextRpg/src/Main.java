import CreatePlayer.Create;
import Menu.GameInterface;
import Scenes.Battle;
import Scenes.Journey;
import Weapon.Bow;
import Weapon.RarityWeapons;
import Weapon.Sword;
import gameEntities.Enemies;
import gameEntities.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Create create = new Create();

       Player player =  create.CreationPlayer();
        Journey.Start(player);
        Enemies enemies = new Enemies(10,20,4);

        Battle.battle(enemies,player);
        System.out.println(player.getHealth());




//        Sword sword = new Sword();
//        System.out.println(sword.getDamage() + " " + sword.getName());
//        Bow bow = new Bow();
//        System.out.println(bow.getDamage() + " " + bow.getName());












    }
}
