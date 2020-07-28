package CreatePlayer;

import gameEntities.Player;

import java.util.Scanner;

public class Create {

private Player player;

    public Player CreationPlayer()
    {
        System.out.println("Введите имя вашего персонажа: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        player = new Player(100,0,10,userName);
        System.out.println("Отлично, вашего персонажа зовут: " + userName);
        return player;
    }

}
