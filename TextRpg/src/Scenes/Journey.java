package Scenes;

import Menu.GameInterface;
import gameEntities.Player;

public  class Journey {

    public static void Start(Player player)
    {
        System.out.println(player.getName() + "," + " добро пожаловать в этот загадочный мир, в данный момент мы находимся\n" +
                "около входа в страшное и темное подземелье, на данный момент у тебя: ");
        GameInterface.showInfo(player);

    }
}
