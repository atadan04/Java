package Weapon;

public class Sword extends Weapons{

    public Sword( ) {
        RarityWeapons rarityWeapons = null; //Creation new sword with random damage according to rarity
        try {
            rarityWeapons = RarityWeapons.getRandomRarity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDamage(this.getDamage() * rarityWeapons.getDamageСoefficient());

        this.setName(rarityWeapons.name() + " Sword");//assigment name according to rarity

    }
}
