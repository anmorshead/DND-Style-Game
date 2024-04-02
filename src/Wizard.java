import javax.swing.*;

public class Wizard extends Player{
    public Wizard(String name, int hp, int defence, int agility, int baseAttack, Weapon weapon, ImageIcon weaponImageLabel, ImageIcon charImageLabel) {
        super(name, hp,defence,agility,baseAttack, weapon, weaponImageLabel, charImageLabel);
        super.setCharImageLabel(new ImageIcon(getClass().getResource("Wizard.jpg")));
    }

    @Override
    public String giveDescription() {
        return "He commands the power of all the ducks in the pond. He can quickly gather a powerful " +
                "duck swarm using his bird seed spell and can easily dodge attacks using speed waddle or swift flight.";
    }
    public void speedWaddle(){

    }
    public void swiftFlight(){

    }

}
