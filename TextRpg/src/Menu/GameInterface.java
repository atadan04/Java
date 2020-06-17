package Menu;

import gameEntities.Player;

public class GameInterface {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static void showInfo(Player player)
    {

        System.out.printf(ANSI_BLUE + "||" + ANSI_RED +"Health - %.1f " +  ANSI_BLUE + "||" + ANSI_RESET,player.getHealth() );
        System.out.printf(ANSI_GREEN + "Armor - %.1f "+ ANSI_BLUE + "||" + ANSI_RESET,player.getArmor());
        System.out.printf(ANSI_PURPLE + "Damage - %.1f "+ ANSI_BLUE + "||" + ANSI_RESET,player.getDamage());
    }
}
