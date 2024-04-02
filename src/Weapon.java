import javax.swing.*;

public class Weapon {
private String weaponName;
private int weight;
private int attackMod;
private String weaponDescription;


//constructor
    public Weapon(String weaponName, int weight, int attackMod) {
        this.weaponName = weaponName;
        this.weight = weight;
        this.attackMod = attackMod;
        if (weaponName =="Winter Staff"){
            weaponDescription="The winter staff commands the power of winter and ice providing its champion " +
                    "with two special spell attacks: Deep freeze, and seasonal affective disorder.";
        }else if(weaponName=="Bow"){
            weaponDescription="Carved by the high elves from the oldest oak tree in the forest. " +
                    "Its arrows always find their mark allowing its champion to deal damage from a safe distance. "+
                    "Its champion has a 1/10 chance of tree pollen affliction though slowing their movement speed for 10s.";
        }else if(weaponName=="War Hammer"){
            weaponDescription="Carved from the most powerful boulder in the forest park by the bear king himself. Its powerful " +
                    "attacks can shake the forest floor knocking down trees and enemies making them vulnerable to " +
                    "additonal attacks. Champions with less than 100 hp will suffer a 5 second power up " +
                    "penalty for all attacks.";
        }
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getWeight() {
        return weight;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public String getDescription() {
        return weaponDescription;

    }

}
