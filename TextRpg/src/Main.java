import CreatePlayer.Create;
import Menu.GameInterface;
import Scenes.Journey;
import gameEntities.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Create create = new Create();
       Player player =  create.CreationPlayer();
        Journey.Start(player);






    }
}
