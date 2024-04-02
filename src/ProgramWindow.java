import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProgramWindow extends JFrame {
    private static Wizard wizard;
    private static Elf elf;
    private static Warrior warrior;
    private static ArrayList<Weapon> weaponList = new ArrayList<>();
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static Monster monster;
    private static int selectedWeapon = 0;
    private static int selectedPlayer = 0;

    //constructor
    public ProgramWindow() {
        this.setBounds(200, 200, 800, 800);//set size of window and location
        this.setTitle("The Realms of Shubie Park");
        this.setLayout(new CardLayout()); //picks card layout style
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when user hits x-close program

        //Initialize characters with null values
        playerList.add(new Wizard(null, Character.generateRandomInt(), Character.generateRandomInt(), Character.generateRandomInt(),Character.generateRandomInt(),null,null,null));
        playerList.add(new Elf(null, Character.generateRandomInt(), Character.generateRandomInt(), Character.generateRandomInt(),Character.generateRandomInt(),null,null,null));
        playerList.add(new Warrior(null, Character.generateRandomInt(), Character.generateRandomInt(), Character.generateRandomInt(),Character.generateRandomInt(),null,null,null));


        //create a list of predefined weapons at start of program
        weaponList.add(new Weapon("Winter Staff",10,15));
        weaponList.add(new Weapon("War Hammer",40,50));
        weaponList.add(new Weapon("Bow",5,15));

        //instantiate random monster at beginning
        monster = new Monster(
                Monster.generateRandomName(),
                Character.generateRandomInt(),
                Character.generateRandomInt(),
                Character.generateRandomInt(),
                Character.generateRandomInt(),
                null
        );

        //Add Panel "screens"
        BattleSummaryScreen battleSummary = new BattleSummaryScreen();
        SplashScreen splash = new SplashScreen();
        CharacterCreationScreen characterCreation = new CharacterCreationScreen();
        this.add(splash);
        this.add(battleSummary);
        this.add(characterCreation);

        JButton build = splash.getBuildButton(); // Access the button from splash screen
        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splash.setVisible(false); // Hide splash screen
                characterCreation.setVisible(true);

            }
        });
        JButton reRoll = characterCreation.getReRollButton();//access reRoll button
        reRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call method to change stat values
                characterCreation.reIssueIntValues();
            }
        });
        JButton start = characterCreation.getStartBattleButton();//access start button
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //take selected values to create final player
                characterCreation.createFinalPlayer();
                characterCreation.setVisible(false);
                battleSummary.setVisible(true);
                //display info on battle summary screen
                battleSummary.displayPlayerInfo();

            }
        });
        JButton again = battleSummary.getPlayAgainButton();
        again.addActionListener(new ActionListener() {//access play again button
            @Override
            public void actionPerformed(ActionEvent e) {
                battleSummary.setVisible(false);
                splash.setVisible(true);
                //reset all values/descriptions when playing new game
                characterCreation.resetValues();
                battleSummary.resetInfoArea();
            }
        });
    }
    public static ArrayList<Weapon> getWeaponList() {
        return weaponList;
    }

    public static int getSelectedWeapon() {
        return selectedWeapon;
    }

    public static void setWeaponList(ArrayList<Weapon> weaponList) {
        ProgramWindow.weaponList = weaponList;
    }

    public static void setSelectedWeapon(int selectedWeapon) {
        ProgramWindow.selectedWeapon = selectedWeapon;
    }

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public static void setPlayerList(ArrayList<Player> playerList) {
        ProgramWindow.playerList = playerList;
    }

    public static int getSelectedPlayer() {
        return selectedPlayer;
    }

    public static Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public static Elf getElf() {
        return elf;
    }

    public void setElf(Elf elf) {
        this.elf = elf;
    }

    public static Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public static Monster getMonster() {
        return monster;
    }

    public static void setMonster(Monster monster) {
        ProgramWindow.monster = monster;
    }

    public static void setSelectedPlayer(int selectedPlayer) {
        ProgramWindow.selectedPlayer = selectedPlayer;
    }

}