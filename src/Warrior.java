import javax.swing.*;

public class Warrior extends Player{
    public Warrior(String name, int hp, int defence, int agility, int baseAttack, Weapon weapon, ImageIcon weaponImageLabel, ImageIcon charImageLabel) {
        super(name, hp,defence,agility,baseAttack, weapon, weaponImageLabel, charImageLabel);
        super.setCharImageLabel(new ImageIcon(getClass().getResource("Warrior.jpg")));
    }

    @Override
    public String giveDescription() {
        return "Fuelled by peanuts the warrior crow is the most powerful character in the forrest park. " +
                "His vicious claw attack has a 1/3 critical hit chance and takes damage from foes at a 50% " +
                "reduced rate due to his small target area.";
    }
    public void clawAttack(){

    }
    public void flyAway(){

    }
}