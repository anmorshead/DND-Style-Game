import javax.swing.*;

public class Player extends Character{
    private Weapon weapon;
    private ImageIcon weaponImageLabel;
    private ImageIcon charImageLabel;

    //constructor
    public Player(String name, int hp, int defence, int agility, int baseAttack, Weapon weapon, ImageIcon weaponImageLabel, ImageIcon charImageLabel) {
        super(name, hp, defence, agility, baseAttack);
        this.weapon = weapon;
        this.weaponImageLabel = weaponImageLabel;
        this.charImageLabel = charImageLabel;
    }

    // Getters and setters for Weapon
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ImageIcon getWeaponImageLabel() {
        return weaponImageLabel;
    }

    public void setWeaponImageLabel(ImageIcon weaponPic) {
        this.weaponImageLabel = weaponPic;
    }

    public Icon getCharImageLabel() {
        return charImageLabel;
    }

    public void setCharImageLabel(ImageIcon charImageLabel) {
        this.charImageLabel = charImageLabel;
    }

    // method for giving description
    public String giveDescription(){
        return " ";
    };


}
