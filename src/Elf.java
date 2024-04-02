import javax.swing.*;

public class Elf extends Player{
    public Elf(String name, int hp, int defence, int agility, int baseAttack, Weapon weapon, ImageIcon weaponImageLabel, ImageIcon charImageLabel) {
        super(name, hp,defence,agility,baseAttack, weapon, weaponImageLabel, charImageLabel);
        super.setCharImageLabel(new ImageIcon(getClass().getResource("Elf.jpg")));
    }

    @Override
    public String giveDescription() {
        return "The magical elven deer silently moves through the forest primarily relying on ranged attacks. " +
                "Their speed allows them a 1/3 chance to dodge any attack but they also become easily stunned "
        +"by any bright headlights within a 500m radius";
    }

    public void stunnedByHeadlights(){

    }
    public void dodge(){

    }
}