import javax.swing.*;
import java.util.Random;

public abstract class Character {
    private String name;
    private int hp;
    private int defence;
    private int agility;
    private int baseAttack;



    //constructor
    public Character(String name, int hp, int defence, int agility, int baseAttack) {
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.agility = agility;
        this.baseAttack = baseAttack;
    }
    //to generate random values when needed
    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generate random int between 1 and 100
    }

    //getters/setters

    public String getName() {
        return name;
    }

    public int getHp() {return hp;
    }

    public int getDefence() {
        return defence;
    }

    public int getAgility() {
        return agility;
    }

    public int getBaseAttack() {
        return baseAttack;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", defence=" + defence +
                ", agility=" + agility +
                ", baseAttack=" + baseAttack +
                '}';
    }


}
