package Weapon;

public class Bow extends Weapons{
    public Bow() {
        RarityWeapons rarityWeapons = null; //Creation new sword with random damage according to rarity
        try {
            rarityWeapons = RarityWeapons.getRandomRarity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDamage(this.getDamage() * rarityWeapons.getDamageСoefficient());

        this.setName(rarityWeapons.name() + " Bow");//assigment name according to rarity
    }
}
