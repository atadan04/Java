package Weapon;

import java.util.Random;

public enum RarityWeapons  {
    COMMON( 1),
    UNCOMMON(2),
    RARE(3),
    MYTHICAL(4),
    LEGENDARY(5),
    IMMORTAL(6);
    private int rarityInNumbers;
    private double damageСoefficient;

    public double getDamageСoefficient() {
        return damageСoefficient;
    }

    RarityWeapons(double rarityInNumbers)
    {
        this.damageСoefficient = Math.random() + rarityInNumbers;
    }
    public static RarityWeapons getRandomRarity() throws Exception {
        Random random = new Random(System.currentTimeMillis());

        int index = random.nextInt(6);
        switch (index)
        {
            case 0:
                return COMMON;
            case 1:
                return UNCOMMON;

            case 2:
                return RARE;

            case 3:
                return MYTHICAL;

            case 4:
                return LEGENDARY;

            case 5:
                return IMMORTAL;

            default:
                throw new Exception();

        }
    }

}
