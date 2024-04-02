import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Monster extends Character {
    // Predefined monster names
    private static String[] monsterNames = {"Squirrel Gang", "Park Compliance", "Wasp Lord"};
    private JLabel monsterImageLabel;
    private String monsterDescription;

    // Constructor
    public Monster(String name, int hp, int defence, int agility, int baseAttack, JLabel monsterImageLabel) {
        super(name, hp, defence, agility, baseAttack);
        this.monsterImageLabel = monsterImageLabel;
        if (name == "Squirrel Gang"){
            monsterDescription="The sneaky squirrel gang can ambush any champion in the forest park without warning. They strike fear into the hearts of all their opponents and will have a 10% increased " +
                    "attack damage against any champions with loose pant legs vulnerable to their attacks. " +
                    "Champions who can perform a peanut spell of distraction can easily escape this foe.";
        }else if (name == "Park Compliance"){
            monsterDescription="A dark wizard who keeps a watchful eye over the park and disapproves of any enjoyable activites. " +
                    "His fluorescent yellow robes strike fear into the hearts of all park goers as his magical " +
                    "banishment spells are nearly impossible to dodge. Luckily the wizard only spawns between " +
                    "2pm and 3pm on sunday afternoons.";
        }else if(name == "Wasp Lord"){
           monsterDescription="The Wasp Lord can quickly ruin any forest park visit with his vicious swarm call or venomous " +
                   "sting attack. Champions carrying any sweet treats are 2x as likely to encounter this enemy.";
        }
    }

    // Method to randomly select a monster name
    public static String generateRandomName() {
        Random random = new Random();
        return monsterNames[random.nextInt(monsterNames.length)];

    }

    public String getMonsterDescription() {
        return monsterDescription;
    }

    public JLabel getMonsterImageLabel() {
        return monsterImageLabel;
    }

    public void setMonsterImageLabel(JLabel monsterImageLabel) {
        this.monsterImageLabel = monsterImageLabel;
    }
    public void attack(){

    }
}
